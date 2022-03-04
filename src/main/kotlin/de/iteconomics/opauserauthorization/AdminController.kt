package de.iteconomics.opauserauthorization

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController {
    @GetMapping
    fun getAdminConfig(): ResponseEntity<AdminConfig> =
            ResponseEntity.ok(adminConfig())

    private fun adminConfig() = AdminConfig()
}

data class AdminConfig(
        val message: String = "Admin Config"
)