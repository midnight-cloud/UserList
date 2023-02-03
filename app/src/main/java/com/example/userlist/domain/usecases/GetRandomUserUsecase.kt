package com.example.userlist.domain.usecases

import com.example.userlist.data.models.Results
import com.example.userlist.domain.repo.UsersRepo
import javax.inject.Inject

class GetRandomUserUsecase @Inject constructor(private val usersRepo: UsersRepo) {
    suspend fun execute() : List<Results> {
        return usersRepo.getRandomUser()
    }
}