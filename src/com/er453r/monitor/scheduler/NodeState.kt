package com.er453r.monitor.scheduler

import com.er453r.monitor.Config
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class NodeState(
        val config: Config
) {
    private val log = KotlinLogging.logger {}

    val root = Node("root")

    fun update(path:String){
        log.info { "Updating $path" }

        val parts = path.split("/")
        var node = root

        parts.forEach { part ->
            if(!node.nodes.containsKey(part)) {
                log.info { "Creating node $part" }

                node.nodes[part] = Node(part)
            }

            node.nodes[part]?.let {
                node = it
            }
        }

        var configNode = config.nodes

        parts.forEach { part ->
            if (!configNode.containsKey(part)){
                log.warn { "No config for part $part!!!" }

                return@forEach
            }
            else
                configNode = configNode[part]!!.nodes
        }
    }
}
