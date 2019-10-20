package com.er453r.monitor

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@Suppress("ConfigurationProperties")
@ConstructorBinding
@ConfigurationProperties(prefix = "monitor")
class Config(
        val user: String,
        val pass: String,
        val commands: Map<String, CommandDefinition> = mapOf(),
        val nodes: Map<String, NodeDefinition> = mapOf()
) {
    class CommandDefinition(
            val cmd: String,
            val timeout: Int = 5,
            val remote: Boolean = true
    )

    class NodeDefinition(
            val commands: Map<String, String> = mapOf(),
            val nodes: MutableMap<String, NodeDefinition>? = mutableMapOf()
    )
}
