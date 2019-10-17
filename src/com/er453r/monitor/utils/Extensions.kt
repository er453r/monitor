package com.er453r.monitor.utils

import org.springframework.core.io.DefaultResourceLoader
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

fun String.resourceText(): String {
    return StreamUtils.copyToString(DefaultResourceLoader().getResource(this).inputStream, StandardCharsets.UTF_8)
}
