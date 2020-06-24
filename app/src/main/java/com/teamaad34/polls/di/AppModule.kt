package com.teamaad34.polls.di

import com.teamaad34.polls.data.repository.voters.IVoterRepository
import com.teamaad34.polls.data.repository.voters.VoterRepository
import com.teamaad34.polls.data.source.IVoterDataSource
import com.teamaad34.polls.data.source.local.VoterLocalDataSource
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

    @Provides
    @Singleton
    @LocalVoterDataSource
    fun provideVoterLocalDataSource(): IVoterDataSource = VoterLocalDataSource()

    @Provides
    @Singleton
    @RemoteVoterDataSource
    fun provideVoterRemoteDataSource(): IVoterDataSource = VoterRemoteDataSource()
}

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideVoterRepository(
        @AppModule.LocalVoterDataSource local: IVoterDataSource,
        @AppModule.RemoteVoterDataSource remote: IVoterDataSource
    ): IVoterRepository = VoterRepository(local, remote)

}