package com.teamaad34.polls

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teamaad34.polls.data.model.Choice
import com.teamaad34.polls.data.model.Question
import com.teamaad34.polls.data.model.User
import com.teamaad34.polls.data.source.local.dao.ChoicesDao
import com.teamaad34.polls.data.source.local.dao.QuestionsDao
import com.teamaad34.polls.data.source.local.dao.UserDao
import com.teamaad34.polls.utils.TimestampConverter

@Database(
    entities = [User::class, Question::class, Choice::class],
    exportSchema = true,
    version = 1
)
@TypeConverters(TimestampConverter::class)
abstract class PollsDatabase : RoomDatabase() {
    abstract val questionsDao: QuestionsDao
    abstract val choicesDao: ChoicesDao
    abstract val userDao: UserDao
}

