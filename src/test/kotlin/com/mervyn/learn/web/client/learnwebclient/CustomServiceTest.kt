package com.mervyn.learn.web.client.learnwebclient

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.jupiter.api.Test

import org.springframework.web.reactive.function.client.WebClient


/**
 * @author  cs-mervyn
 * @date  2023/5/23 19:20
 * @version 1.0
 */
 class CustomServiceTest{
    @Test
    fun test(){
       val server = MockWebServer()
        val url = server.url("/retrieve/data")
        val dispatcher: Dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                when (request.path) {
                    "/retrieve/data" -> return MockResponse().setResponseCode(200).setHeader("Content-type", "application/json").setBody("{\"name\":\"csmervyn\",\"age\":\"11\"}")
                    "/v1/check/version/" -> return MockResponse().setResponseCode(200).setBody("version=9")
                    "/v1/profile/info" -> return MockResponse().setResponseCode(200).setBody("{\\\"info\\\":{\\\"name\":\"Lucas Albuquerque\",\"age\":\"21\",\"gender\":\"male\"}}")
                }
                return MockResponse().setResponseCode(404)
            }
        }
        server.dispatcher = dispatcher
        val customService = CustomService()
        customService.webClient = WebClient.builder().build()
        customService.url = url.toUrl().toString()
        customService.sendMessage()
    }
}