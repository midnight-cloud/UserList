package com.example.userlist.presenter

import android.app.Application
import com.example.userlist.presenter.di.DaggerAppComponent

class App: Application() {

    val appComponent = DaggerAppComponent.create()

}