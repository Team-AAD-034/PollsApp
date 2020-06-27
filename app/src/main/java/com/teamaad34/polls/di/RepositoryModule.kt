package com.teamaad34.polls.di

import com.teamaad34.polls.data.repository.choice.ChoicesRepository
import com.teamaad34.polls.data.repository.choice.IChoicesRepository
import com.teamaad34.polls.data.repository.question.IQuestionsRepository
import com.teamaad34.polls.data.repository.question.QuestionsRepository
import com.teamaad34.polls.data.repository.user.IUserRepository
import com.teamaad34.polls.data.repository.user.UserRepository
import com.teamaad34.polls.data.source.IChoiceDataSource
import com.teamaad34.polls.data.source.IQuestionDataSource
import com.teamaad34.polls.data.source.IUserDataSource
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
    fun provideUserRepository(
        @LocalUserDataSource local: IUserDataSource,
        @RemoteUserDataSource remote: IUserDataSource,
        ioDispatcher: CoroutineDispatcher
    ): IUserRepository = UserRepository(local, remote, ioDispatcher)

    @Provides
    @Singleton
    fun provideQuestionRepository(
        @LocalQuestionDataSource local: IQuestionDataSource,
        @RemoteQuestionDataSource remote: IQuestionDataSource,
        ioDispatcher: CoroutineDispatcher
    ): IQuestionsRepository = QuestionsRepository(local, remote, ioDispatcher)

    @Provides
    @Singleton
    fun provideChoiceRepository(
        @LocalChoiceDataSource local: IChoiceDataSource,
        @RemoteChoiceDataSource remote: IChoiceDataSource,
        ioDispatcher: CoroutineDispatcher
    ): IChoicesRepository = ChoicesRepository(local, remote, ioDispatcher)

}