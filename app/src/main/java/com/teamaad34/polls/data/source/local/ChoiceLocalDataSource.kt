package com.teamaad34.polls.data.source.local

import androidx.lifecycle.LiveData
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.TaskResult.Success
import com.teamaad34.polls.data.model.Choice
import com.teamaad34.polls.data.source.IChoiceDataSource
import com.teamaad34.polls.data.source.local.dao.ChoicesDao

/**
 * Does CRUD(Create, Read, Update & Delete) operations in the local database with the help of
 * Room Dao
 */
class ChoiceLocalDataSource internal constructor(private val dao: ChoicesDao) : IChoiceDataSource {
    override suspend fun createChoice(choice: Choice): TaskResult<Choice> {
        dao.createChoice(choice)
        return Success(dao.getChoice(choice.id))
    }

    override suspend fun createChoices(choices: List<Choice>): TaskResult<List<Choice>> {
        val questionIds = choices.map { it.questionId }.toSet()
        dao.createChoices(choices)
        // if questionId(s) in choices from param are ALL similar, return choices with that question
        // id otherwise return all choices
        return Success(if (questionIds.size == 1) dao.getChoices(questionIds.first()) else dao.getChoices())
    }

    override suspend fun removeChoice(choice: Choice) = Success(dao.removeChoice(choice))

    override suspend fun removeChoice(id: String) = Success(dao.removeChoice(id))

    override suspend fun getChoices(questionId: String?) =
        Success(if (questionId.isNullOrBlank()) dao.getChoices() else dao.getChoices(questionId))

    override suspend fun getObservableChoices(questionId: String?): LiveData<List<Choice>> =
        if (questionId.isNullOrBlank()) dao.getObservableChoices()
        else dao.getObservableChoices(questionId)
}