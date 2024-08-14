package net.diegoqueres.mongodocker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongodbDockerApplication

fun main(args: Array<String>) {
	runApplication<MongodbDockerApplication>(*args)
}
