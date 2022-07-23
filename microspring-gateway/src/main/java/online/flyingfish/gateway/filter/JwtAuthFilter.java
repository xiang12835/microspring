package online.flyingfish.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/*
设置与 JWT Token 相关的安全认证信息，给所有经过 API 网关的 HTTP 请求添加了一个消息头
全局过滤器
 */
@Configuration
public class JwtAuthFilter implements GlobalFilter {
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
        builder.header("Authorization","JWTToken");
        return chain.filter(exchange.mutate().request(builder.build()).build());
    }
}
