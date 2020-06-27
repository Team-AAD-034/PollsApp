package com.teamaad34.polls.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import com.google.firebase.Timestamp

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = false)
    var id: String = "",
    var question: String = "",
    var description: String = "",
    var publicationDate: String = "",
    var creationDate: Timestamp = Timestamp.now(),
    @Ignore val choices: List<Choice> = emptyList()
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(Timestamp::class.java.classLoader) ?: Timestamp.now(),
        (parcel.createTypedArrayList(Choice) ?: arrayListOf()).toList()
    )

    fun wasPublishedRecently(): Boolean {
        return false
    }

    fun wasCreatedRecently(): Boolean {
        return false
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.run {
            writeString(id)
            writeString(question)
            writeString(description)
            writeParcelable(creationDate, flags)
            writeTypedList(choices)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question = Question(parcel)

        override fun newArray(size: Int): Array<Question?> = arrayOfNulls(size)
    }
}

data class QuestionWithChoices(
    @Embedded
    val query: Question,
    @Relation(parentColumn = "id", entityColumn = "questionId")
    val choices: List<Choice> = emptyList()
) {
    val question: Question
        get() = query.copy(choices = choices)
}