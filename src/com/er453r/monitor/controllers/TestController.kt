package com.er453r.monitor.controllers

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController {
    private val log = KotlinLogging.logger {}

    @GetMapping("check")
    fun test(): String {
        log.info { "Everything OK log :)" }

        return "Everything OK!"
    }
}
