package com.er453r.monitor.controllers

import com.er453r.monitor.Config
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController(
        val config:Config
) {
    private val log = KotlinLogging.logger {}

    @GetMapping("check")
    fun test(): String {
        log.info { "Everything OK log :) ${config.user} ${config.pass}" }

        return "Everything OK!"
    }
}
