package com.example.myapplication3


    data class UserData(
        val user:UserInfo,
        val token:String
    )
data class UserInfo(
    val id:Int,
    val firstname:String,
    val lastname:String,
    val patronymic:String,
    val email:String,
    val sex:String,
    val dateBirthDay:String
)
data class LogB(
    val email:String,
    val password:String
)
data class RegB(
    val lastname: String,
    val firstname: String,
    val patronymic: String,
    val email: String,
    val password: String,
    val dateBirthDay: String,
    val sex: String
)
