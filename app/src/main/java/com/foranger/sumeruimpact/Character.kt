package com.foranger.sumeruimpact

import android.os.Parcelable
<<<<<<< HEAD
import android.provider.ContactsContract.CommonDataKinds.Email
=======
>>>>>>> c1dd0f08dd4d23283dbe8a9b9a12da2e742cd34d
import android.sax.Element
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val nickname: String,
    val introduction: String,
    val thumbnail: Int,
    val visionIcon: Int,
    val quality: Int,
    val portrait: Int,
    val weapon: String,
    val photoSplash: String,
    val vision: String,
    val constellation: String,
    val affiliation: String,
    val birthday: String,
    val dish: String,
) : Parcelable