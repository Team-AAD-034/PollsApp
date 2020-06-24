package com.teamaad34.polls.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.TaskResult.Success
import com.teamaad34.polls.data.listData
import com.teamaad34.polls.data.model.Question
import com.teamaad34.polls.data.source.IQuestionDataSource

class QuestionRemoteDataSource internal constructor() : IQuestionDataSource {
    override suspend fun createQuestion(question: Question): TaskResult<Question> {
        TODO("Not yet implemented")
    }

    override suspend fun createQuestions(questions: List<Question>) = Success(questions)

    override suspend fun removeQuestion(question: Question): TaskResult<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun removeQuestion(id: String): TaskResult<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestion(id: String): TaskResult<Question> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestions(): TaskResult<List<Question>> {
        TODO("Not yet implemented")
    }

    override suspend fun getObservableQuestions() = MutableLiveData(getQuestions().listData)
}