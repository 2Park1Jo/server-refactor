package com.twoparkhanjo.lobster.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = parseBearerToken(request);  //요청 헤더에서 bearer token을 가져옴

            if (token != null && !token.equalsIgnoreCase("null")) {
                String email = jwtTokenProvider.validate(token);
                AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        email, null, AuthorityUtils.NO_AUTHORITIES
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  //provider에서 토큰 인증 후 사용자 인증 정보 저장

                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();  //인증된 사용자 정보 등록
                securityContext.setAuthentication(authenticationToken);

                SecurityContextHolder.setContext(securityContext);
            }
        } catch (Exception e) {
            logger.error("Could not set authentication and security context");
        }

        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        final String SEPERATOR = "Bearer ";

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(SEPERATOR)) {
            return bearerToken.replace(SEPERATOR, "");
        }

        return null;
    }
}
