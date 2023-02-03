package com.example.userlist.domain.usecases

import com.example.userlist.data.models.Results
import com.example.userlist.domain.repo.UsersRepo
import javax.inject.Inject

class GetUserListByParamsUsecase @Inject constructor(private val usersRepo: UsersRepo) {
    suspend fun execute(count: Int, gender: String?, nat: String?) : List<Results> {
        return usersRepo.getUserListByParams(count, gender, nat)
    }
}