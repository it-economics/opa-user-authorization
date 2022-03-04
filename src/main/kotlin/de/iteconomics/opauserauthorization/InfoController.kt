package de.iteconomics.opauserauthorization

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/info")
@RestController
class InfoController {
    @GetMapping
    fun getInfo(): ResponseEntity<Info> =
            ResponseEntity.ok(info())

    private fun info() = Info()
}

data class Info(
        val app: String = "Foo",
        val version: String = "0.1.1"
)