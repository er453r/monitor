package com.er453r.monitor.scheduler

import com.er453r.monitor.Config
import com.fasterxml.jackson.annotation.JsonIgnore

class Node(
        var name: String,
        @JsonIgnore val parent: Node?, // so it wont loop
        val commands: Map<String, String> = mapOf(),
        val nodeDefinition: Config.NodeDefinition? = null,
        val nodes: MutableMap<String, Node> = mutableMapOf()
) {
    val fullName: String
        get() = if (parent == null) name else "${parent.fullName}/$name"

    fun find(path:String):Node?{
        if(fullName == path)
            return this

        nodes.values.forEach {
            it.find(path)?.let {
                return it
            }
        }

        return null
    }
}
