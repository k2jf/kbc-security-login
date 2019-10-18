package com.k2data.kbc.security.login.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2data.kbc.api.KbcResponse;
import com.k2data.kbc.security.login.util.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        SecurityUtil.setResponseCorsHeader(request, response);
        KbcResponse resp = new KbcResponse("认证成功");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}