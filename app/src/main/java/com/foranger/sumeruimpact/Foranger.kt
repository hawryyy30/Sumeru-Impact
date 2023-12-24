package com.foranger.sumeruimpact

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Email
import android.sax.Element
import kotlinx.parcelize.Parcelize

@Parcelize
data class Foranger(
    val forangerPhoto: Int,
    val forangerName: String,
    val forangerEmail: String,
    val forangerJobDesc: String
) : Parcelable
