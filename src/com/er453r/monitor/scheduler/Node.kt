package com.er453r.monitor.scheduler

import com.fasterxml.jackson.annotation.JsonIgnore

class Node(
        var name: String,
        @JsonIgnore val parent: Node?, // so it wont loop
        val commands: Map<String, String> = mapOf(),
        val nodes: MutableMap<String, Node> = mutableMapOf()
) {
    val fullName: String
        get() = if (parent == null) name else "${parent.fullName}/$name"
}
