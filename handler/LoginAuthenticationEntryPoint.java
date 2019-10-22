package com.k2data.kbc.security.login.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2data.kbc.api.KbcResponse;
import com.k2data.kbc.security.login.util.SecurityUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        SecurityUtil.setResponseCorsHeader(request, response);
        KbcResponse resp = new KbcResponse("请重新登录");
        response.setStatus(401);
        response.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
