package com.example.userlist.data.network

import com.example.userlist.data.models.RequestResult
import com.example.userlist.data.models.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("/api")
    suspend fun getRandomUser(): Response<RequestResult>

    @GET("/api")
    suspend fun getUserList(
        @Query("results") results: Int
    ): Response<RequestResult>

    @GET("/api")
    suspend fun getUserListByParams(
        @Query("results") results: Int,
        @Query("gender") gender: String?,
        @Query("nat") nat: String?
    ): Response<RequestResult>
}