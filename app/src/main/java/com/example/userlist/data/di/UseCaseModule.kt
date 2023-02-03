package com.example.userlist.data.di

import com.example.userlist.data.Mapper
import com.example.userlist.data.repo.UsersListRepoImpl
import com.example.userlist.domain.usecases.GetRandomUserUsecase
import com.example.userlist.domain.usecases.GetUserListByParamsUsecase
import com.example.userlist.domain.usecases.GetUserListUsecase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideUserListUsecase(usersRepo: UsersListRepoImpl) : GetUserListUsecase {
        return GetUserListUsecase(usersRepo)
    }

    @Provides
    fun provideRandomUserUsecase(usersRepo: UsersListRepoImpl) : GetRandomUserUsecase {
        return GetRandomUserUsecase(usersRepo)
    }

    @Provides
    fun provideUserListByParams(usersRepo: UsersListRepoImpl) : GetUserListByParamsUsecase {
        return GetUserListByParamsUsecase(usersRepo)
    }

    @Provides
    fun provideMapper() : Mapper {
        return Mapper()
    }
}