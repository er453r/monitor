package com.er453r.monitor.controllers

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TasksController {
    private val log = KotlinLogging.logger {}

    @GetMapping("tasks")
    fun tasks(id: String): String {
        log.info { "Node $id reporting for duty!" }

        return "do nothing $id\n"
    }
}
