package de.iteconomics.opauserauthorization

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/info")
@RestController
class InfoController {
    @GetMapping
    fun getInfo(): ResponseEntity<Info> =
            ResponseEntity.ok(info())

    private fun info() = Info()

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateInfo(@RequestBody updatedInfo: Info) =
            ResponseEntity.accepted().body(updatedInfo)
}

data class Info(
        val app: String = "Foo",
        val version: String = "0.1.1"
)