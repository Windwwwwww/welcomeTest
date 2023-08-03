package com.welcome.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.welcome.Result.Code;
import com.welcome.exception.BusinessException;
import com.welcome.exception.SystemException;

import java.util.Calendar;
import java.util.Date;

public class JwtUtil {
    public static String createToken(String userId, String userName) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("userName", userName)    //载荷
                .sign(Algorithm.HMAC256(userName+"welcome"));   //加密
    }
    public static void verifyToken(String token, String secret) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret+"welcome")).build();
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            //效验失败
            throw new BusinessException("校验失败",e, Code.BACKSTAGE_ERROR);
        }
    }
    public static String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            //这里是token解析失败
            throw new SystemException("服务器异常",e,Code.BACKSTAGE_ERROR);
        }
        return audience;
    }
    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }
}
