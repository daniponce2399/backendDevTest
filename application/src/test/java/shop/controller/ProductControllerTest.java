package shop.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import shop.dto.ProductDto;
import shop.services.SearchProductsService;


@WebFluxTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    SearchProductsService searchProductsService;

    @Test
    public void obtainSearchProductsTest(){
        Mockito.when(searchProductsService.searchProduct("productId")).thenReturn(Flux.just(new ProductDto()));

        webTestClient.get()
                .uri("/product/productId/similar")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray();
    }
}