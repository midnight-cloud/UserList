package com.example.userlist.domain.trueModels

import com.example.userlist.domain.models.Location
import com.example.userlist.domain.models.Name
import com.example.userlist.domain.models.Picture

data class UserModel(
    val id: String?,
    val gender: String?,
    val name: Name?,
    val picture: Picture?,
    val location: Location?
)
