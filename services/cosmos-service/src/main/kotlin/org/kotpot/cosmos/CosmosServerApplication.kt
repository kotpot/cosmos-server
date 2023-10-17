package org.kotpot.cosmos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CosmosServerApplication

fun main(args: Array<String>) {
	runApplication<CosmosServerApplication>(*args)
}
