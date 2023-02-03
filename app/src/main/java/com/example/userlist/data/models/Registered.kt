package com.example.userlist.data.models

import com.google.gson.annotations.SerializedName

data class Registered (

    @SerializedName("date" ) var date : String? = null,
    @SerializedName("age"  ) var age  : String?    = null

)
