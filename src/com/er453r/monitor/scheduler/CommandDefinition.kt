package com.er453r.monitor.scheduler

class CommandDefinition(
        val cmd: String,
        val timeout: Int = 5,
        val remote: Boolean = true
)
