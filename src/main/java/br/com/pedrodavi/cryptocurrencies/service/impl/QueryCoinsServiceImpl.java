package br.com.pedrodavi.cryptocurrencies.service.impl;

import br.com.pedrodavi.cryptocurrencies.service.QueryCoinsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QueryCoinsServiceImpl {

    private final QueryCoinsService service;

    public ResponseEntity<String> getCurrency() throws JSONException {
        JSONObject jsonObject = new JSONObject(service.getCoins().getBody());
        JSONObject brlJSON = jsonObject.optJSONObject("BRL");
        String brl = brlJSON.getString("15m");
        return ResponseEntity.ok(brl);
    }

}
