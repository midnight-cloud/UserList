package com.example.userlist.data.models

import com.google.gson.annotations.SerializedName

data class Coordinates (

    @SerializedName("latitude"  ) var latitude  : String? = null,
    @SerializedName("longitude" ) var longitude : String? = null

)
