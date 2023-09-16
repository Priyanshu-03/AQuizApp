package com.myprojects.aquizapp

import android.os.Parcel
import android.os.Parcelable

data class Index(val img: Int, val title: String, val quizID: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(img)
        parcel.writeString(title)
        parcel.writeInt(quizID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Index> {
        override fun createFromParcel(parcel: Parcel): Index {
            return Index(parcel)
        }

        override fun newArray(size: Int): Array<Index?> {
            return arrayOfNulls(size)
        }
    }
}