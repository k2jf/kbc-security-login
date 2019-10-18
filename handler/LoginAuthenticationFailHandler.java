package com.k2data.kbc.security.login.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2data.kbc.api.KbcResponse;
import com.k2data.kbc.security.login.util.SecurityUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAuthenticationFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        SecurityUtil.setResponseCorsHeader(request, response);
        KbcResponse resp = new KbcResponse("认证失败");
        response.setStatus(403);
        response.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
