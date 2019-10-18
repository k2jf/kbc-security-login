package com.k2data.kbc.security.login.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2data.kbc.api.KbcResponse;
import com.k2data.kbc.security.login.util.SecurityUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        SecurityUtil.setResponseCorsHeader(request, response);
        KbcResponse resp = new KbcResponse("权限不足");
        response.setStatus(403);
        response.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }


}
