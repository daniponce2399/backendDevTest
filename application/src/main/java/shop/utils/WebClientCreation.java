package shop.utils;

import org.springframework.web.reactive.function.client.WebClient;

/**
 * Class which creates webclient connections
 */
public class WebClientCreation {

    /**
     * Obtain webClient for localhost 3001
     *
     * @return WebClient
     */
    public WebClient webClientCreation(){
        return WebClient.create("http://localhost:3001");
    }
}
