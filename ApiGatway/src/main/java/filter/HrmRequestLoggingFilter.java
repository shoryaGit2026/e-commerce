package filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.util.UUID;

@Component
@Slf4j
public class HrmRequestLoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();
        String requestId = UUID.randomUUID().toString();
        exchange.getResponse().getHeaders().add("X-Request-Id",requestId);
        String path = exchange.getRequest().getURI().getPath();
        String method = exchange.getRequest().getMethod().name();
        String user = exchange.getRequest().getHeaders().getFirst("X-User-Id");
        log.info("[REQ] id={} user={} {} {}",requestId,user,method,path);
        return chain.filter(exchange).doOnSuccess(v->{
            long totalTimeTaken = System.currentTimeMillis()-startTime;
            log.info("[Res] id={} id={}",requestId,totalTimeTaken);
        }).doOnError(e->{
            log.info("Need to do implementation");
        });
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
