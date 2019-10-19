package com.er453r.monitor.scheduler

class Node(
        var name: String? = null,
        val commands: Map<String, String> = mapOf(),
        val nodes: MutableMap<String, Node> = mutableMapOf()
)
