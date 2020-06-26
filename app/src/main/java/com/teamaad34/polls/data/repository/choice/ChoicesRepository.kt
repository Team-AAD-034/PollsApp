package com.teamaad34.polls.data.repository.choice

import com.teamaad34.polls.data.data
import com.teamaad34.polls.data.listData
import com.teamaad34.polls.data.model.Choice
import com.teamaad34.polls.data.source.IChoiceDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChoicesRepository internal constructor(
    private val local: IChoiceDataSource,
    private val remote: IChoiceDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IChoicesRepository {
    override suspend fun createChoice(choice: Choice) = withContext(ioDispatcher) {
        remote.createChoice(choice).run {
            local.createChoice(data ?: choice)
        }
    }

    override suspend fun createChoices(choices: List<Choice>) = withContext(ioDispatcher) {
        remote.createChoices(choices).run {
            local.createChoices(data ?: choices)
        }
    }

    override suspend fun removeChoice(choice: Choice) = withContext(ioDispatcher) {
        remote.removeChoice(choice).run {
            local.removeChoice(choice)
        }
    }

    override suspend fun removeChoice(id: String) = withContext(ioDispatcher) {
        remote.removeChoice(id).run {
            local.removeChoice(id)
        }
    }

    override suspend fun getChoices(questionId: String?) = withContext(ioDispatcher) {
        remote.getChoices(questionId).run {
            local.createChoices(listData)
//            local.getChoices(questionId) // Repetitive - done by above
        }
    }

    override suspend fun getObservableChoices(questionId: String?) =
        local.getObservableChoices(questionId)
}