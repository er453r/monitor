package com.er453r.monitor.controllers

import mu.KotlinLogging
import org.junit.Before
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TestControllerTest(
    @Autowired val mockMvc: MockMvc
) {
    private val log = KotlinLogging.logger {}

    @Before
    fun init() {
        log.info { "Setting up tests..." }
    }

    @Test
    fun `Unsecure endpoint test`() {
        mockMvc.perform(get("/test/check"))
            .andExpect(status().isOk)
            .andExpect(content().string("Everything OK!"))
    }
}
