package com.aalvarez.hexagonal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootApplication
public class HexagonalApplication {

	/**
	 * TODO: FALTA AGREGAR TEST UNITARIOS.
	 */

	public static void main(String[] args) {
		final ConfigurableApplicationContext context =  SpringApplication.run(HexagonalApplication.class, args);
		final AtomicInteger counter = new AtomicInteger(0);
		log.info("****************** Beans Registrados *******************", context.getBeanDefinitionCount());
		Arrays.asList(context.getBeanDefinitionNames())
				.forEach(beanName -> {
					System.out.println("{} Bean : {} " + counter.incrementAndGet() + " " + beanName);
				});
		log.info("********************************************************", context.getBeanDefinitionCount());
	}

}
