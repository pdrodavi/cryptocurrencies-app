package br.com.pedrodavi.cryptocurrencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan("br.com.pedrodavi.cryptocurrencies")
public class CryptocurrenciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptocurrenciesApplication.class, args);
	}

}
