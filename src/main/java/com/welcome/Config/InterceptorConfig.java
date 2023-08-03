package com.welcome.Config;

import com.welcome.Interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //默认拦截所有路径
        registry.addInterceptor(getJwtInterceptor())
                .addPathPatterns("/backstage","/backstage/*");
    }
    @Bean
    public JwtInterceptor getJwtInterceptor() {
        return new JwtInterceptor();
    }
}
