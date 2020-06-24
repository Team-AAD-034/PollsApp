package com.teamaad34.polls.di

import com.teamaad34.polls.data.repository.choices.ChoicesRepository
import com.teamaad34.polls.data.repository.choices.IChoicesRepository
import com.teamaad34.polls.data.repository.questions.IQuestionsRepository
import com.teamaad34.polls.data.repository.questions.QuestionsRepository
import com.teamaad34.polls.data.repository.voters.IVoterRepository
import com.teamaad34.polls.data.repository.voters.VoterRepository
import com.teamaad34.polls.data.source.IChoiceDataSource
import com.teamaad34.polls.data.source.IQuestionDataSource
import com.teamaad34.polls.data.source.IVoterDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideVoterRepository(
        @AppModule.LocalVoterDataSource local: IVoterDataSource,
        @AppModule.RemoteVoterDataSource remote: IVoterDataSource
    ): IVoterRepository = VoterRepository(local, remote)

    @Provides
    @Singleton
    fun provideQuestionRepository(
        @AppModule.LocalQuestionDataSource local: IQuestionDataSource,
        @AppModule.RemoteQuestionDataSource remote: IQuestionDataSource,
        ioDispatcher: CoroutineDispatcher
    ): IQuestionsRepository = QuestionsRepository(local, remote, ioDispatcher)

    @Provides
    @Singleton
    fun provideChoiceRepository(
        @AppModule.LocalChoiceDataSource local: IChoiceDataSource,
        @AppModule.RemoteChoiceDataSource remote: IChoiceDataSource,
        ioDispatcher: CoroutineDispatcher
    ): IChoicesRepository = ChoicesRepository(local, remote, ioDispatcher)

}