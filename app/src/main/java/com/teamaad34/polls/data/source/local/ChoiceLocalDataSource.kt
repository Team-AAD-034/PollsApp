package com.teamaad34.polls.data.source.local

import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.TaskResult.Success
import com.teamaad34.polls.data.model.Choice
import com.teamaad34.polls.data.source.IChoiceDataSource
import com.teamaad34.polls.data.source.local.dao.ChoicesDao

class ChoiceLocalDataSource internal constructor(private val dao: ChoicesDao) : IChoiceDataSource {
    override suspend fun createChoice(choice: Choice): TaskResult<Choice> {
        dao.createChoice(choice)
        return Success(dao.getChoice(choice.id))
    }

    override suspend fun removeChoice(choice: Choice) = Success(dao.removeChoice(choice))

    override suspend fun removeChoice(id: String) = Success(dao.removeChoice(id))

    override suspend fun getChoices(questionId: String) = Success(dao.getChoices(questionId))

    override suspend fun getObservableChoices(questionId: String) =
        dao.getObservableChoices(questionId)
}