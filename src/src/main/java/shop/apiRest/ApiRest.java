package shop.apiRest;

import reactor.core.publisher.Flux;
import shop.dto.ProductDto;

/**
 * Api Rest Class
 */
public interface ApiRest {
    /**
     * Method which searches similar ids to the product introduced
     *
     * @param productId String
     * @return Flux<Integer>
     */
    Flux<Integer> findProductSimilarIds(String productId);

    /**
     * Method which searches details of the product id introduced
     *
     * @param productId String
     * @return Flux<ProductDto>
     */
    Flux<ProductDto> findDetailOfSimilarProducts(String productId);
}
