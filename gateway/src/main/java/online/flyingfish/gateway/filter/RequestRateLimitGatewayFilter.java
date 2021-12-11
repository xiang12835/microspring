package online.flyingfish.gateway.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import com.google.common.util.concurrent.RateLimiter;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* 限流
*
* 令牌桶算法，Google Guava 的RateLimiter 都是一些基于此算法的实现
* 这里我们简单使用一个 Map 来存储 bucket，所以也决定了它只能单点使用，如果是分布式的话，可以采用 Hazelcast 或 Redis 等解决方案。
* https://dqy20200405.blog.csdn.net/article/details/109264487
* https://www.cnblogs.com/xhq1024/p/11726873.html
*
* */

@CommonsLog
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRateLimitGatewayFilter implements GatewayFilter, Ordered {

    int capacity; // 桶的最大容量，即能装载 Token 的最大数量
    int refillTokens; // 每次 Token 补充量
    Duration refillDuration; // 补充 Token 的时间间隔

    // 不同的方法存放不同的令牌桶
    private final Map<String, RateLimiter> bucket = new ConcurrentHashMap<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String url = "/hello";
        RateLimiter rateLimiter;
        // 判断map集合中是否有创建好的令牌桶
        if (bucket.containsKey(url)) {
            rateLimiter = bucket.get(url);
        } else {
            // 创建一个限速器，每1秒，产生2个令牌
            rateLimiter = RateLimiter.create(1, 1, TimeUnit.SECONDS);
            bucket.put(url, rateLimiter);
        }

        // 获取令牌
        // timeout：获取令牌等待超时时间；timeunit：超时时间单位
        boolean acquire = rateLimiter.tryAcquire(200, TimeUnit.MILLISECONDS);

        if (acquire) {
            log.info("获取令牌成功");
            //获取令牌成功
            return chain.filter(exchange);
        } else {
            log.info("请求被限流,url");
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return -1000;
    }

}