package com.er453r.monitor.controllers

import com.er453r.monitor.scheduler.Command
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class TasksController {
    private val log = KotlinLogging.logger {}

    @GetMapping("tasks")
    fun tasks(id: String): String {
        log.info { "Node $id reporting for duty!" }

        val commands = arrayOf(
            Command("uptime"),
            Command("sleep", arrayOf("10"))
        )

        var job = "${UUID.randomUUID()}\n"

        commands.forEach {
            job += "${it.cmd} ${it.timeout} ${it.args.joinToString(" ")}\n"
        }

        return job
    }

    @PostMapping("report")
    fun report(token: String, @RequestBody data: String) {
        log.info { "Task $token\nreporting results:\n$data" }
    }
}
