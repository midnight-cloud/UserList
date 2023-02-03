package com.example.userlist.data.di

import com.example.userlist.data.network.RetrofitServices
import com.example.userlist.data.repo.UsersListRepoImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson) : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun providesRetrofitServices(retrofit: Retrofit) : RetrofitServices {
        return retrofit.create(RetrofitServices::class.java)
    }

    @Provides
    fun provideUsersListRepoImpl(retrofitServices: RetrofitServices) : UsersListRepoImpl {
        return UsersListRepoImpl(retrofitServices)
    }

}