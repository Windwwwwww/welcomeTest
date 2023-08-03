package com.welcome.Interceptor;

import com.welcome.Result.Code;
import com.welcome.Token.PassToken;
import com.welcome.Utils.JwtUtil;
import com.welcome.domain.User;
import com.welcome.exception.BusinessException;
import com.welcome.mapper.UserMapper;
import com.welcome.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    UserMapper mapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //默认全部检查
        else {
            System.out.println("被jwt拦截需要验证");
            // 执行认证
            if (token == null) {
                //这里其实是登录失效,没token了   这个错误也是我自定义的，读者需要自己修改
                throw new BusinessException("你还没有登录或登录状态过时", Code.BACKSTAGE_ERROR);
            }

            // 获取 token 中的 id
            String userId = JwtUtil.getAudience(token);

            //找找看是否有这个user   因为我们需要检查用户是否存在，读者可以自行修改逻辑
            User user = mapper.selectById(userId);

            if (user == null) {

                throw new BusinessException("用户信息错误",Code.BACKSTAGE_ERROR);
            }

            // 验证 token
            JwtUtil.verifyToken(token, userId);

            //获取载荷内容
            String userName = JwtUtil.getClaimByName(token, "userName").asString();
            //放入attribute以便后面调用
            request.setAttribute("userName", userName);

            return true;

        }
        return true;
    }
}
