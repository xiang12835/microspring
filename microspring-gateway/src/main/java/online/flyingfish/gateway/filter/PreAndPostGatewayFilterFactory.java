package online.flyingfish.gateway.filter;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.filter.GatewayFilter;

@Component
public class PreAndPostGatewayFilterFactory extends AbstractGatewayFilterFactory<PreAndPostGatewayFilterFactory.Config> {
    public PreAndPostGatewayFilterFactory() {
        super(Config.class);
    }

    public GatewayFilter apply() {
        return apply(o -> {
        });
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            //针对request的各种处理

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                //针对response的各种处理
            }));
        };
    }

    public static class Config {

    }

}
