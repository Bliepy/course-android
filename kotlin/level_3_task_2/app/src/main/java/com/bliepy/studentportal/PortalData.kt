package com.bliepy.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PortalData (  val title: String, val url: String): Parcelable