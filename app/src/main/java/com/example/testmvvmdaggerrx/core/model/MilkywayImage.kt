package com.example.testmvvmdaggerrx.core.model

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class MilkywayImage(
    val title: String?,
    val id: String?,
    val center: String?,
    val description: String?,
    val date: Date?,
    val imageUri: Uri?
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        Date(parcel.readLong()),
        parcel.readParcelable(Uri::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(id)
        parcel.writeString(center)
        parcel.writeString(description)
        parcel.writeParcelable(imageUri, flags)
        date?.time?.let { parcel.writeLong(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MilkywayImage> {
        override fun createFromParcel(parcel: Parcel): MilkywayImage {
            return MilkywayImage(parcel)
        }

        override fun newArray(size: Int): Array<MilkywayImage?> {
            return arrayOfNulls(size)
        }
    }
}