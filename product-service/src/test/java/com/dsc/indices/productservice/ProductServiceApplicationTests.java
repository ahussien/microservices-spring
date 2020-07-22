package com.dsc.indices.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
@ComponentScan("se.magnus")
class ProductServiceApplicationTests {
	@Test
	void contextLoads() {
	}

	@Configuration
	@ComponentScan("se.magnus")
	@ComponentScan("com.dsc.indices")
	public static class SpringConfig {

	}
}
