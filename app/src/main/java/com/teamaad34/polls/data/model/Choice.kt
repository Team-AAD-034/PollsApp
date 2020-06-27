package com.teamaad34.polls.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "choices",
    foreignKeys = [ForeignKey(
        entity = Question::class,
        parentColumns = ["id"],
        childColumns = ["questionId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [
        Index(
            name = "choice_question_id_index",
            value = ["questionId", "id"]
        )
    ]
)
data class Choice(
    @PrimaryKey(autoGenerate = false)
    val id: String = "",
    val questionId: String = "",
    val choice: String = "",
    val votes: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.run {
            writeString(id)
            writeString(questionId)
            writeString(choice)
            writeInt(votes)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Choice> {
        override fun createFromParcel(parcel: Parcel): Choice = Choice(parcel)

        override fun newArray(size: Int): Array<Choice?> = arrayOfNulls(size)
    }
}