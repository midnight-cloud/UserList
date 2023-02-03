package com.example.userlist.data

import com.example.userlist.domain.models.Location
import com.example.userlist.domain.models.Picture
import com.example.userlist.domain.trueModels.UserModel
import javax.inject.Inject
import com.example.userlist.data.models.Results as DataResutls
import com.example.userlist.domain.models.Results as DomainResutls

class Mapper @Inject constructor() {
    fun mapDataResultToDomainUser(input: DataResutls) : UserModel {
        return UserModel(
            id = input.id?.value,
            gender = input.gender ?: "",
            name = com.example.userlist.domain.models.Name(
                title = input.name?.title,
                first = input.name?.first,
                last = input.name?.last
            ),
            picture = Picture(
                large = input.picture?.large,
                medium = input.picture?.medium,
                thumbnail = input.picture?.thumbnail
            ),
            location = Location(
                city = input.location?.city,
                country = input.location?.country
            )
        )
    }

    fun mapDomainResultToDomainUser(input: DomainResutls) : UserModel {
        return UserModel(
            id = input.id?.value,
            gender = input.gender ?: "",
            name = com.example.userlist.domain.models.Name(
                title = input.name?.title,
                first = input.name?.first,
                last = input.name?.last
            ),
            picture = Picture(
                large = input.picture?.large,
                medium = input.picture?.medium,
                thumbnail = input.picture?.thumbnail
            ),
            location = Location(
                city = input.location?.city,
                country = input.location?.country
            )
        )
    }
}