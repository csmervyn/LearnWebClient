package com.mervyn.learn.web.client.learnwebclient

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author  cs-mervyn
 * @date  2023/5/23 19:09
 * @version 1.0
 */
data class User(
        @JsonProperty("name") val name: String,
        @JsonProperty("occupation")val age: Int)
