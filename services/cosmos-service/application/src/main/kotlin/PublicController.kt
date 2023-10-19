package org.kotpot.cosmos

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/public")
class PublicController {

    @GetMapping("/check")
    suspend fun check(): String {
        return "Hello Cosmos!"
    }
}