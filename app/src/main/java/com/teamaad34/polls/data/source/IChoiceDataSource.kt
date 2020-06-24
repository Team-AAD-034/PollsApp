package com.teamaad34.polls.data.source

import androidx.lifecycle.LiveData
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.model.Choice

interface IChoiceDataSource {
    suspend fun createChoice(choice: Choice): TaskResult<Choice>

    suspend fun removeChoice(choice: Choice): TaskResult<Int>

    suspend fun removeChoice(id: String): TaskResult<Int>

    suspend fun getChoices(questionId: String): TaskResult<List<Choice>>

    suspend fun getObservableChoices(questionId: String): LiveData<List<Choice>>
}