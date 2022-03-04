package de.iteconomics.opauserauthorization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class OpaUserAuthorizationApplication

fun main(args: Array<String>) {
    runApplication<OpaUserAuthorizationApplication>(*args)
}
