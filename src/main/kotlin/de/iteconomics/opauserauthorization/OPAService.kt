package de.iteconomics.opauserauthorization

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class OPAService(
        private val opaConfig: OPAConfig
) {
    fun checkAccess(authentication: Authentication, method: String, pathElements: List<String>): Boolean {
        val result = webClient()
                .post()
                .uri("/v1/data/authz/allow")
                .bodyValue(mapOf(
                        "input" to mapOf(
                                "method" to method,
                                "path" to pathElements
                        )
                ))
                .retrieve()
                .bodyToMono<OPAResult>()
                .block()?.result
        return result ?: false
    }

    private fun webClient() = WebClient.create(opaConfig.url)
}

data class OPAResult(
        val result: Boolean
)
