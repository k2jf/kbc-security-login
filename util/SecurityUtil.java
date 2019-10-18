package com.k2data.kbc.security.login.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityUtil {

    /**
     * response 设置跨域以及编码
     *
     * @param request
     * @param response
     */
    public static void setResponseCorsHeader(HttpServletRequest request, HttpServletResponse response) {
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        // 允许自定义请求头token(允许head跨域)
        response.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
    }

    /**
     * 获取用户信息
     *
     * @return String userName
     */
    public static String getUserName() {
        String userName = null;
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null) {
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        return userName;
    }

    /**
     * 密码加密
     *
     * @param password 原文
     * @return 密文
     */
    public static String encodePassword(String password) {
        PasswordEncoder passwordEncoder = SpringUtil.getBean(PasswordEncoder.class);
        return passwordEncoder.encode(password);
    }

    /**
     * 密码原文和密文匹配
     *
     * @param password        原文
     * @param encodedPassword 密文
     * @return boolean
     */
    public static boolean passwordMatchs(String password, String encodedPassword) {
        PasswordEncoder passwordEncoder = SpringUtil.getBean(PasswordEncoder.class);
        return passwordEncoder.matches(password, encodedPassword);
    }
}
