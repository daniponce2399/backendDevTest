package shop.services.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import shop.apiRest.ApiRest;
import shop.dto.ProductDto;
import shop.services.SearchProductsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class SearchProductsServiceImplTest {

    @Autowired
    SearchProductsService searchProductsService;
    @MockBean
    ApiRest apiRest;

    @Test
    public void searchProductsServiceOkTest(){
        Flux<Integer> ids = Flux.just(1,2,3);
        ProductDto productDto = mock(ProductDto.class);
        Mockito.when(apiRest.findProductSimilarIds("productId")).thenReturn(ids);
        Mockito.when(apiRest.findDetailOfSimilarProducts(Mockito.anyString())).thenReturn(Flux.just(productDto));


        Flux<ProductDto> response = searchProductsService.searchProduct("productId");

        assertThat(response.blockFirst()).isEqualTo(productDto);
    }

    @Test
    public void searchProductsServiceKoTest(){
        Flux<Integer> ids = Flux.just(1);
        Mockito.when(apiRest.findProductSimilarIds("productId")).thenReturn(ids);
        Mockito.when(apiRest.findDetailOfSimilarProducts("1")).thenReturn(Flux.error(new Exception()));


        Flux<ProductDto> response = searchProductsService.searchProduct("productId");
        StepVerifier.create(response).verifyError();
    }
}