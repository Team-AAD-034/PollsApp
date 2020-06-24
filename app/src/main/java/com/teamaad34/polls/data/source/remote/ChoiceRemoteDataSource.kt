package com.teamaad34.polls.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.listData
import com.teamaad34.polls.data.model.Choice
import com.teamaad34.polls.data.source.IChoiceDataSource

class ChoiceRemoteDataSource internal constructor() : IChoiceDataSource {
    override suspend fun createChoice(choice: Choice): TaskResult<Choice> {
        TODO("Not yet implemented")
    }

    override suspend fun removeChoice(choice: Choice): TaskResult<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun removeChoice(id: String): TaskResult<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun getChoices(questionId: String): TaskResult<List<Choice>> {
        TODO("Not yet implemented")
    }

    override suspend fun getObservableChoices(questionId: String): LiveData<List<Choice>> {
        return MutableLiveData(getChoices(questionId).listData)
    }
}