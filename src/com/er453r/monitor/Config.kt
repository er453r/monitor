package com.er453r.monitor

import com.er453r.monitor.scheduler.CommandDefinition
import com.er453r.monitor.scheduler.Node
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "monitor")
class Config(
        val user: String,
        val pass: String,
        val commands: Map<String, CommandDefinition> = mapOf(),
        val nodes: Map<String, Node> = mapOf()
)
