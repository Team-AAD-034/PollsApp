package com.teamaad34.polls.di

import com.teamaad34.polls.data.source.IChoiceDataSource
import com.teamaad34.polls.data.source.IQuestionDataSource
import com.teamaad34.polls.data.source.IVoterDataSource
import com.teamaad34.polls.data.source.local.ChoiceLocalDataSource
import com.teamaad34.polls.data.source.local.QuestionLocalDataSource
import com.teamaad34.polls.data.source.local.VoterLocalDataSource
import com.teamaad34.polls.data.source.local.dao.ChoicesDao
import com.teamaad34.polls.data.source.local.dao.QuestionsDao
import com.teamaad34.polls.data.source.remote.ChoiceRemoteDataSource
import com.teamaad34.polls.data.source.remote.QuestionRemoteDataSource
import com.teamaad34.polls.data.source.remote.VoterRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalVoterDataSource

    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteVoterDataSource

    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalQuestionDataSource

    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteQuestionDataSource

    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalChoiceDataSource

    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteChoiceDataSource

    @Provides
    @Singleton
    @LocalVoterDataSource
    fun provideVoterLocalDataSource(): IVoterDataSource = VoterLocalDataSource()

    @Provides
    @Singleton
    @RemoteVoterDataSource
    fun provideVoterRemoteDataSource(): IVoterDataSource = VoterRemoteDataSource()

    @Provides
    @Singleton
    @LocalQuestionDataSource
    fun provideQuestionLocalDataSource(dao: QuestionsDao): IQuestionDataSource =
        QuestionLocalDataSource(dao)

    @Provides
    @Singleton
    @RemoteQuestionDataSource
    fun provideQuestionRemoteDataSource(): IQuestionDataSource = QuestionRemoteDataSource()

    @Provides
    @Singleton
    @LocalChoiceDataSource
    fun provideChoiceLocalDataSource(dao: ChoicesDao): IChoiceDataSource =
        ChoiceLocalDataSource(dao)

    @Provides
    @Singleton
    @RemoteChoiceDataSource
    fun provideChoiceRemoteDataSource(): IChoiceDataSource = ChoiceRemoteDataSource()
}