package com.teamaad34.polls.data.source

import androidx.lifecycle.LiveData
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.model.Question

interface IQuestionDataSource {
    suspend fun createQuestion(question: Question): TaskResult<Question>

    suspend fun createQuestions(questions: List<Question>): TaskResult<List<Question>>

    suspend fun removeQuestion(question: Question): TaskResult<Int>

    suspend fun removeQuestion(id: String): TaskResult<Int>

    suspend fun getQuestion(id: String): TaskResult<Question>

    suspend fun getQuestions(): TaskResult<List<Question>>

    suspend fun getObservableQuestions(): LiveData<List<Question>>
}