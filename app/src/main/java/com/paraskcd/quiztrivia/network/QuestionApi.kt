package com.paraskcd.quiztrivia.network

import com.paraskcd.quiztrivia.models.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
        suspend fun getAllQuestions(): Question
}