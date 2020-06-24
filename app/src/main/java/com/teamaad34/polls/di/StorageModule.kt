package com.teamaad34.polls.di

import android.content.Context
import androidx.room.Room
import com.teamaad34.polls.PollsDatabase
import com.teamaad34.polls.data.source.local.dao.ChoicesDao
import com.teamaad34.polls.data.source.local.dao.QuestionsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object StorageModule {
    @Provides
    @Singleton
    fun providePollsDatabase(@ApplicationContext context: Context): PollsDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            PollsDatabase::class.java,
            "polls.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideQuestionsDao(db: PollsDatabase): QuestionsDao = db.questionsDao

    @Provides
    @Singleton
    fun provideChoicesDao(db: PollsDatabase): ChoicesDao = db.choicesDao
}