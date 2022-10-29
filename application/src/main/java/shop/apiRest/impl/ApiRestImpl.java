package shop.apiRest.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import shop.apiRest.ApiRest;
import shop.dto.ProductDto;
import shop.exceptions.ProcessFailureException;
import shop.utils.WebClientCreation;

import java.time.Duration;


@Slf4j
@Component
@AllArgsConstructor
public class ApiRestImpl implements ApiRest {

    private final WebClientCreation webClientCreation;

    /**
     * Method which searches similar ids to the product introduced
     *
     * @param productId String
     * @return Flux<Integer>
     */
    @Override
    public Flux<Integer> findProductSimilarIds(String productId){

        WebClient webClient = webClientCreation.webClientCreation();
        final String productIdPath = "{productId}";
        final String path = "/product/" + productIdPath + "/similar";

        int timeout = 60;
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .build(productId))
                .retrieve()
                .bodyToFlux(Integer.class)
                .timeout(Duration.ofSeconds(timeout))
                .onErrorResume(e ->{
                    e.printStackTrace();
                    log.error("Error trying to find similar ids from productId ({})", productId, e);
                    return Mono.error(new ProcessFailureException(productId));
                });
    }

    /**
     * Method which searches details of the product id introduced
     *
     * @param productId String
     * @return Flux<ProductDto>
     */
    @Override
    public Flux<ProductDto> findDetailOfSimilarProducts(String productId){

        WebClient webClient = webClientCreation.webClientCreation();
        final String productIdPath = "{productId}";
        final String path = "/product/" + productIdPath +"";

        int longTimeout = 5000;
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .build(productId))
                .retrieve()
                .bodyToFlux(ProductDto.class)
                .timeout(Duration.ofSeconds(longTimeout))
                .onErrorResume(e ->{
                    e.printStackTrace();
                    log.error("Error trying to find details from productId ({})", productId, e);
                    return Mono.error(new ProcessFailureException(productId));
                });

    }
}
