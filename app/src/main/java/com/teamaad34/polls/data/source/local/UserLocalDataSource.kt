package com.teamaad34.polls.data.source.local

import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.TaskResult.Success
import com.teamaad34.polls.data.model.User
import com.teamaad34.polls.data.source.IUserDataSource
import com.teamaad34.polls.data.source.local.dao.UserDao

/**
 * Does CRUD(Create, Read, Update & Delete) operations in the local database with the help of
 * Room Dao
 */
class UserLocalDataSource internal constructor(private val dao: UserDao) : IUserDataSource {
    override suspend fun createUser(user: User): TaskResult<User> {
        dao.createUser(user)
        return getUser(user.cacheId)
    }

    override suspend fun deleteUser(user: User) = Success(dao.deleteUser(user))

    override suspend fun getUser(cacheId: Int) = Success(dao.getUser(cacheId))

    override suspend fun getUser(id: String) = Success(dao.getUser(id))

    override suspend fun getObservableUser(cacheId: Int) = dao.getObservableUser(cacheId)

    override suspend fun getObservableUser(id: String) = dao.getObservableUser(id)
}