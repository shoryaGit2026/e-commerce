package filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@Slf4j
public class CorrelationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String correlationId=exchange.getRequest().getHeaders().getFirst("CorrelationId");
        if(correlationId==null)
        {
            correlationId = UUID.randomUUID().toString();
            exchange.getResponse().getHeaders().add("CorrelationId",correlationId);
        }

        return chain.filter(exchange).doOnSuccess(r->{

            log.info("");
        });
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
