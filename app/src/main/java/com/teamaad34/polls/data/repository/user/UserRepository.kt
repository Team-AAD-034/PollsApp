package com.teamaad34.polls.data.repository.user

import com.teamaad34.polls.data.source.IUserDataSource

class UserRepository internal constructor(
    private val local: IUserDataSource,
    private val remote: IUserDataSource
) : IUserRepository {
}