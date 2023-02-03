package com.example.userlist.presenter.di

import com.example.userlist.presenter.fragments.MainFragment
import com.example.userlist.data.di.NetworkModule
import com.example.userlist.data.di.UseCaseModule
import com.example.userlist.presenter.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, UseCaseModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)


}