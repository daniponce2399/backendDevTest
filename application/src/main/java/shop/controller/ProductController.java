package shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import shop.dto.ProductDto;
import shop.services.SearchProductsService;

/**
 * Product controller class
 */
@RestController
@AllArgsConstructor
public class ProductController {

    private final SearchProductsService searchProductsService;

    /**
     * Controller for obtaining similar products by id
     *
     * @param productId String
     * @return Flux<ProductDto>
     */
    @GetMapping("/product/{productId}/similar")
    public Flux<ProductDto> searchProducts(@PathVariable String productId){
        return searchProductsService.searchProduct(productId);
    }
}
