package com.teamaad34.polls.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String? = null,
    val isSuperuser: Boolean = false
)