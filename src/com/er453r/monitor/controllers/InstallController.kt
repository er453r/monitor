package com.er453r.monitor.controllers

import com.er453r.monitor.utils.resourceText
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class InstallController {
    private val log = KotlinLogging.logger {}

    @GetMapping("install")
    fun install(@RequestHeader("Host") host: String): String {
        log.info { "Requesting install from host $host" }

        return "monitor.sh".resourceText().replace("HOST", host)
    }
}
