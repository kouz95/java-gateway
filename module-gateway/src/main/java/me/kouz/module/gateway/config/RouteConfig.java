package me.kouz.module.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("members", p -> p
                        .path("/api/members")
                        .uri("lb://MEMBER/"))
                .route("memberById", ps -> ps
                        .path("/api/members/**")
                        .filters(fs -> fs.rewritePath("/api/members/?<segment>.*", "/api/members/{segment}"))
                        .uri("lb://MEMBER/"))
                .build();
    }
}
