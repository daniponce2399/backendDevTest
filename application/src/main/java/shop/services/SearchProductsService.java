package shop.services;

import reactor.core.publisher.Flux;
import shop.dto.ProductDto;

/**
 * Search product service
 */
public interface SearchProductsService {

    /**
     * Method to get the selected product and similar products
     *
     * @param productId String
     * @return Flux<ProductDto>
     */
    Flux<ProductDto> searchProduct(String productId);
}
