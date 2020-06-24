package com.teamaad34.polls.data.repository.voters

import com.teamaad34.polls.data.source.IVoterDataSource

class VoterRepository internal constructor(
    private val local: IVoterDataSource,
    private val remote: IVoterDataSource
) : IVoterRepository {
}