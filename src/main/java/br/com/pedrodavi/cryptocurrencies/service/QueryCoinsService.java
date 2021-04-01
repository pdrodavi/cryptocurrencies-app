package br.com.pedrodavi.cryptocurrencies.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "coinsService", url = "https://blockchain.info/ticker")
public interface QueryCoinsService {

    @GetMapping
    ResponseEntity<String> getCoins();

}
