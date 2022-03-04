package de.iteconomics.opauserauthorization

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "opa-user-authorization.opa")
data class OPAConfig(
        val url: String
)