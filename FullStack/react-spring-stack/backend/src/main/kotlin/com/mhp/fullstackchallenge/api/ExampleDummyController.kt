package com.mhp.fullstackchallenge.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class ExampleDummyController {

    @GetMapping("/hello")
    fun getHelloWorld() = " hello world from the backend"
}
