package com.example.belgorod.presentation.module

import android.provider.ContactsContract
import java.time.LocalDate
import java.util.*

data class PersonalInfo(
    var rating:Float,
    var numberRespondents: Int,
    val personImage: String,
    val name: String,
    val about_myself:String,
    val city:String,
    val birthday: LocalDate,
    val achievement: String,
    val smoking: String,
    val alchocol: String,
    val telephon: String
)