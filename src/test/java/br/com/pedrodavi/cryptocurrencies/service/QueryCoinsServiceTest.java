package br.com.pedrodavi.cryptocurrencies.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
class QueryCoinsServiceTest {

    private static String URL_API = "https://blockchain.info/ticker";

    @Test
    void getCoins() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URL_API, String.class);
        System.out.println(response.getBody());
    }

}