package com.example.userlist.data.models

import com.google.gson.annotations.SerializedName

data class RequestResult(
    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()
)
