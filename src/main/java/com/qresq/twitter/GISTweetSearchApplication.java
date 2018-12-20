package com.qresq.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * The Class EventApplication.
 */
@SpringBootApplication
@EnableScheduling
public class GISTweetSearchApplication {

    /**
     * Instantiates a new event application.
     */
    public GISTweetSearchApplication() {
        super();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(GISTweetSearchApplication.class, args);
    }
    
    /**
	 * Rest template.
	 *
	 * @param restTemplateBuilder
	 *            the rest template builder
	 * @return the rest template
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setConnectTimeout(5000).setReadTimeout(5000).build();
	}
}
