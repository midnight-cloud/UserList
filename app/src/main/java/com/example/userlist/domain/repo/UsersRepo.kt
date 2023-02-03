package com.example.userlist.domain.repo

import com.example.userlist.data.models.Results

interface UsersRepo {
    suspend fun getRandomUser(): List<Results>
    suspend fun getUserList(count: Int): List<Results>
    suspend fun getUserListByParams(count: Int, gender: String?, nat: String?) : List<Results>
}