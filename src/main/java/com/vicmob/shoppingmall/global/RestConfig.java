package com.vicmob.shoppingmall.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author vicmob
 *
 */
@Configuration
public class RestConfig {
	
	@Bean
	public ClientHttpRequestFactory httpClientFactory() {
		SimpleClientHttpRequestFactory httpClientFactory = new SimpleClientHttpRequestFactory();
		httpClientFactory.setConnectTimeout(2000);
		httpClientFactory.setReadTimeout(10000);
		return httpClientFactory;
	}

	@Bean
	public RestTemplate restTemplate(ClientHttpRequestFactory httpClientFactory) {
		RestTemplate restTemplate = new RestTemplate(httpClientFactory);
		return restTemplate;
	}
}
