package com.teamaad34.polls.data.repository.user

import com.teamaad34.polls.data.data
import com.teamaad34.polls.data.model.User
import com.teamaad34.polls.data.source.IUserDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository internal constructor(
    private val local: IUserDataSource,
    private val remote: IUserDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IUserRepository {
    override suspend fun createUser(user: User) = withContext(ioDispatcher) {
        remote.createUser(user).run {
            local.createUser(data ?: user)
        }
    }

    override suspend fun deleteUser(user: User) = withContext(ioDispatcher) {
        remote.deleteUser(user).run {
            local.deleteUser(user)
        }
    }

    override suspend fun getUser(cacheId: Int) = withContext(ioDispatcher) {
        // call to remote could probably be unnecessary for cacheId
        remote.getUser(cacheId).run {
            local.getUser(data?.cacheId ?: cacheId)
        }
    }

    override suspend fun getUser(id: String) = withContext(ioDispatcher) {
        remote.getUser(id).run {
            local.getUser(data?.id ?: id)
        }
    }

    override suspend fun getObservableUser(cacheId: Int) = local.getObservableUser(cacheId)

    override suspend fun getObservableUser(id: String) = local.getObservableUser(id)
}