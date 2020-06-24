package com.teamaad34.polls.data.repository.choices

import com.teamaad34.polls.data.source.IChoiceDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ChoicesRepository internal constructor(
    private val local: IChoiceDataSource,
    private val remote: IChoiceDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IChoicesRepository {
}