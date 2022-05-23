package com.dkb.url.shorten.controller

import com.dkb.url.shorten.model.ShortUrlRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class UrlShorteningControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
){
    val baseUrl : String = "/dbk/api/urlshortening"

    @Nested
    @DisplayName("POST /dbk/api/urlshortening")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GenerateShortUrl {
        @Test
        fun `should generate short url` () {
            val originalUrl = "https://www.dkb.com/bank/overview"
            val request = ShortUrlRequest(originalUrl)
            val performPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(request)
            }
            performPost
                .andDo { print() }
                .andExpect {
                status { isCreated() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.original_url") {value(originalUrl)}
            }
        }
        @Test
        fun `should return not found` () {
            val invalidId  = "abcdef"
            mockMvc.get(baseUrl+"/"+invalidId)
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }
        }
    }
}