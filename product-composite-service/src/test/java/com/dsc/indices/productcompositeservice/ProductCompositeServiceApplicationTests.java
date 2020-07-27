package com.dsc.indices.productcompositeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class ProductCompositeServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Configuration
	@ComponentScan("se.magnus")
	@ComponentScan("com.dsc.indices")
	public static class SpringConfig {

	}
}
