package com.teamaad34.polls.data.source

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.model.User

interface IUserDataSource {
    suspend fun createUser(user: User): TaskResult<User>

    suspend fun deleteUser(user: User) : TaskResult<Int>

    /**
     * @param cacheId id used to achieve local uniqueness in a sqlite db
     */
    suspend fun getUser(cacheId: Int): TaskResult<User>

    /**
     * @param id should be a FirebaseUser uid
     */
    suspend fun getUser(id: String): TaskResult<User>

    /**
     * @see getUser
     */
    suspend fun getObservableUser(cacheId: Int): LiveData<User>

    /**
     * @see getUser
     */
    suspend fun getObservableUser(id: String): LiveData<User>
}