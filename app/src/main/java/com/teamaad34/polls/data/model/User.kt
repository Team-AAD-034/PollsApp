package com.teamaad34.polls.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude

@Entity
data class User(
    val id: String,
    val name: String? = null,
    val isSuperuser: Boolean = false,
    @Exclude // Used locally
    @PrimaryKey(autoGenerate = false)
    /**
     * Do not provide a different value during instantiation.
     *
     * Only necessary for storing a cache of unique signed in user in local database.
     */
    val cacheId: Int = 1
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.run {
            writeString(id)
            writeString(name)
            writeByte(if (isSuperuser) 1 else 0)
            writeInt(cacheId)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User = User(parcel)

        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}