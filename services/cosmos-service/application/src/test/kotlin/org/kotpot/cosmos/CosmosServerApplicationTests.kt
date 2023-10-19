package org.kotpot.cosmos

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.PropertySource

@PropertySource("classpath:application.properties")
@SpringBootTest(classes = [CosmosServerApplication::class])
class CosmosServerApplicationTests {

	@Test
	fun contextLoads() {
	}

}
