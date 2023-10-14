package com.wesleg.devopsproject.adapters.in.controller.filter;

import com.wesleg.devopsproject.adapters.out.UserCrudAdapter;
import com.wesleg.devopsproject.core.domain.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class FilterAuth extends OncePerRequestFilter {
    private final UserCrudAdapter userCrudAdapter;

    private static final String UNAUTHORIZED_MESSAGE = "Unauthorized";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/api-docs") ||
            (request.getRequestURI().equals("/user") && request.getMethod().equals("POST"))) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Basic")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED_MESSAGE);
            return;
        }

        String authorizationEncoded = authorization.substring("Basic".length()).trim();
        String[] authorizationDecoded = new String(Base64.getDecoder().decode(authorizationEncoded)).split(":");

        if (authorizationDecoded.length != 2) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED_MESSAGE);
            return;
        }

        String username = authorizationDecoded[0];
        String password = authorizationDecoded[1];

        if (!isAuthorized(username, password)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED_MESSAGE);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean isAuthorized(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        User user = userCrudAdapter.get(username).orElse(null);

        return user != null && password.equals(user.getPassword());
    }
}
