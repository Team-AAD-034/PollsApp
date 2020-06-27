package com.teamaad34.polls.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.data
import com.teamaad34.polls.data.model.User
import com.teamaad34.polls.data.source.IUserDataSource

/**
 * Does CRUD(Create, Read, Update & Delete) operations in the remote sever(Firebase)
 */
class UserRemoteDataSource internal constructor() : IUserDataSource {
    override suspend fun createUser(user: User): TaskResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User): TaskResult<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(cacheId: Int): TaskResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(id: String): TaskResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getObservableUser(cacheId: Int): LiveData<User> =
        MutableLiveData(getUser(cacheId).data)

    override suspend fun getObservableUser(id: String): LiveData<User> =
        MutableLiveData(getUser(id).data)
}