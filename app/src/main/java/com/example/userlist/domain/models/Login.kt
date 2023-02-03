package com.example.userlist.domain.models


data class Login (

    var uuid     : String? = null,
    var username : String? = null,
    var password : String? = null,
    var salt     : String? = null,
    var md5      : String? = null,
    var sha1     : String? = null,
    var sha256   : String? = null

)
