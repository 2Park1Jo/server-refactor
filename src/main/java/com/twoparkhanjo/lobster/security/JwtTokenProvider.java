package com.twoparkhanjo.lobster.security;

import com.twoparkhanjo.lobster.domain.member.Member;
import com.twoparkhanjo.lobster.dto.MemberLoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtTokenProvider {
    private static final String SECRET_KEY = System.getenv("JASYPT_PASSWORD");

    public String createToken(Member member) {
        Date expireDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS)); //토큰 유효 기간 1일

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)  //header
                .setSubject(member.getEmail())                   //payload
                .setIssuer("twoparkhanjo")
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .compact();
    }

    public String validate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();  //email
    }
}
