package com.example.userlist.data.repo

import com.example.userlist.data.models.Results
import com.example.userlist.data.network.RetrofitServices
import com.example.userlist.domain.repo.UsersRepo
import retrofit2.HttpException
import javax.inject.Inject

class UsersListRepoImpl @Inject constructor(private val retrofitServices: RetrofitServices) : UsersRepo {
    override suspend fun getRandomUser(): List<Results> {
        val apiResponce = retrofitServices.getRandomUser()
        if (apiResponce.isSuccessful) {
            return apiResponce.body()!!.results
        } else {
            throw HttpException(apiResponce)
        }
    }

    override suspend fun getUserList(count: Int): List<Results> {
        val apiResponce = retrofitServices.getUserList(count)
        if (apiResponce.isSuccessful) {
            return apiResponce.body()!!.results
        } else {
            throw HttpException(apiResponce)
        }
    }

    override suspend fun getUserListByParams(
        count: Int,
        gender: String?,
        nat: String?
    ): List<Results> {
        val apiResponce = retrofitServices.getUserListByParams(count, gender, nat)
        if (apiResponce.isSuccessful) {
            return apiResponce.body()!!.results
        } else {
            throw HttpException(apiResponce)
        }
    }

}