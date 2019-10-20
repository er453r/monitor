package com.er453r.monitor.scheduler

import com.er453r.monitor.Config
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class NodeState(
        config: Config
) {
    private val log = KotlinLogging.logger {}

    val root = Node("root", null)

    init {
        log.info { "Populating nodes from config" }

        config.nodes.entries.forEach {
            add(it.key, it.value, root)
        }
    }

    fun add(name: String, nodeDefinition: Config.NodeDefinition, parent: Node) {
        val node = Node(name, parent)

        log.info { "Created node ${node.fullName}" }

        parent.nodes[name] = node

        nodeDefinition.nodes?.entries?.forEach {
            add(it.key, it.value, node)
        }
    }

    fun update(path: String) {
        log.info { "Updating $path" }

//        val parts = path.split("/")
//        var node = root
//
//        parts.forEach { part ->
//            if(!node.nodes.containsKey(part)) {
//                log.info { "Creating node $part" }
//
//                node.nodes[part] = Node(part)
//            }
//
//            node.nodes[part]?.let {
//                node = it
//            }
//        }
//
//        var configNode = config.nodes
//
//        parts.forEach { part ->
//            if (!configNode.containsKey(part)){
//                log.warn { "No config for part $part!!!" }
//
//                return@forEach
//            }
//            else
//                configNode = configNode[part]!!.nodes
//        }
    }
}
