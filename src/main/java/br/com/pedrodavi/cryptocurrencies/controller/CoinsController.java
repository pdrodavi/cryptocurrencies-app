package br.com.pedrodavi.cryptocurrencies.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedrodavi.cryptocurrencies.service.impl.QueryCoinsServiceImpl;

@RestController
@AllArgsConstructor
public class CoinsController {

    private final QueryCoinsServiceImpl queryCoinsServiceImpl;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/btc")
    public ResponseEntity<String> getValue() throws JSONException {
        return queryCoinsServiceImpl.getCurrency();
    }

}
