package com.mervyn.learn.web.client.learnwebclient

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient

/**
 * @author  cs-mervyn
 * @date  2023/5/23 19:01
 * @version 1.0
 */
class CustomService {
    lateinit var webClient: WebClient
    lateinit var url: String

    fun sendMessage(){
       val response =  webClient
                .post()
                .uri(url)
               .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData("name","mervyn"))
                .retrieve()
               //.toEntity(User::class.java)
        .bodyToMono(User::class.java)
        val message = response.block() as User
       // val user =  (message !!. body) as User
        println(message.name)
         println(message.age)
//         println(message)
    }
}