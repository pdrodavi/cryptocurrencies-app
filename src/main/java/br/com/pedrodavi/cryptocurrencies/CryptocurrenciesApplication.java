package br.com.pedrodavi.cryptocurrencies;

import br.com.pedrodavi.cryptocurrencies.service.impl.QueryCoinsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@EnableFeignClients
@SpringBootApplication
@Controller
@ComponentScan("br.com.pedrodavi.cryptocurrencies")
public class CryptocurrenciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptocurrenciesApplication.class, args);
	}

	@Autowired
	private QueryCoinsServiceImpl service;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/")
	public String index(Model model) throws JSONException {
		ResponseEntity<String> responseEntity = service.getCurrency();
		String btc = responseEntity.getBody();

		// formatando para formato BRL
		double btcDouble = Double.parseDouble(btc);
		DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
		formatoDois.setMinimumFractionDigits(2);
		formatoDois.setParseBigDecimal (true);

		String btcFormatted = formatoDois.format(btcDouble);
		String btcValue = "R$ "+ btcFormatted;

		model.addAttribute("value", btcValue);

		return "index";
	}

}
