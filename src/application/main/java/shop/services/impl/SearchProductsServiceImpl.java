package shop.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import shop.apiRest.ApiRest;
import shop.dto.ProductDto;
import shop.exceptions.ProcessFailureException;
import shop.services.SearchProductsService;

/**
 *  SearchProductsServiceImpl class
 */
@Slf4j
@Component
@AllArgsConstructor
public class SearchProductsServiceImpl implements SearchProductsService {

    private final ApiRest apiRest;

    /**
     * Method to get the selected product and similar products
     *
     * @param productId String
     * @return Flux<ProductDto>
     */
    @Override
    public Flux<ProductDto> searchProduct(String productId) {
        Flux<Integer> similarProductsById = apiRest.findProductSimilarIds(productId);
        return similarProductsById.flatMap(id -> apiRest.findDetailOfSimilarProducts(id.toString()))
                .onErrorResume(e ->{
                    log.error("Error trying to find details from productId ({})", productId, e);
                    return Mono.error(new ProcessFailureException("Error404"));
                });
    }
}
