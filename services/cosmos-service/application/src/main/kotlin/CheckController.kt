package org.kotpot.cosmos

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CheckController {

    @GetMapping("/public/check")
    suspend fun hello(): String {
        return "Hello Cosmos!"
    }
}