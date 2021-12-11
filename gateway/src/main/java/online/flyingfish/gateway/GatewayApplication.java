package online.flyingfish.gateway;

import online.flyingfish.gateway.filter.RateLimitByIpGatewayFilter;
import online.flyingfish.gateway.filter.RequestRateLimitGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/api/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new RequestRateLimitGatewayFilter()))
                        .uri("http://localhost:8080/hello")
                )
                .build();
        // @formatter:on
    }

/*
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/api/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new RateLimitByIpGatewayFilter(3, 1, Duration.ofSeconds(2))))
                .uri("http://localhost:9090/hello")
                )
                .build();
        // @formatter:on
    }

 */


}
