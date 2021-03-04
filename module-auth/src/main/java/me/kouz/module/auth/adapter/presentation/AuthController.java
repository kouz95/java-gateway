package me.kouz.module.auth.adapter.presentation;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
public class AuthController {

    @GetMapping("/")
    public Mono<String> login(@AuthenticationPrincipal Mono<OAuth2User> oAuth2User) {
        return oAuth2User.map(user -> Jwts.builder()
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .signWith(SignatureAlgorithm.HS256, "secretKey")
                .compact());

    }
}
