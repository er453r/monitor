package com.er453r.monitor.scheduler

import com.er453r.monitor.Config
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class NodeState(
        val config: Config
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
        val node = Node(
                name = name,
                nodeDefinition = nodeDefinition,
                parent = parent
        )

        log.info { "Created node ${node.fullName}" }

        parent.nodes[name] = node

        nodeDefinition.nodes?.entries?.forEach {
            add(it.key, it.value, node)
        }
    }

    fun update(path: String) {
        log.info { "Updating $path" }

        var parent = root

        path.split("/").forEach { part ->
            parent.nodes[part]?.let {
                parent = it
            } ?: run {
                log.info { "Creating node without definition $part" }

                Node(
                        name = part,
                        parent = parent
                ).let {
                    parent.nodes[part] = it
                    parent = it
                }
            }
        }
    }

    fun getConfig(path: String):Array<Command> {
        val commands = mutableListOf<Command>()

        root.find(path)?.let { // TODO figure out id we should check for commands recursively?
            it.commands.forEach {
                val commandId = it.key
                val commandArguments = it.value

                config.commands[commandId]?.let {
                    commands.add(Command(
                            cmd = it.cmd,
                            args = arrayOf(commandArguments)
                    ))
                } ?: run {
                    log.warn { "No such command: $commandId" }
                }
            }
        }

        return commands.toTypedArray()
    }
}
