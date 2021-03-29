package com.company.project.utils;

import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;

/**
 * token工具类
 */
public class TokenUtil {
    /**
     * 获取请求的token
     */
    public static String getRequestToken(HttpServletRequest httpRequest) {

        //从header中获取token
        String token = httpRequest.getHeader("X-Token");
        //如果header中不存在token，则从参数中获取token
        if (Strings.isNullOrEmpty(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }
}
