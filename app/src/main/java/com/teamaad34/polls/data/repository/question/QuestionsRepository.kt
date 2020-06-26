package com.teamaad34.polls.data.repository.question

import com.teamaad34.polls.data.data
import com.teamaad34.polls.data.listData
import com.teamaad34.polls.data.model.Question
import com.teamaad34.polls.data.source.IQuestionDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestionsRepository internal constructor(
    private val local: IQuestionDataSource,
    private val remote: IQuestionDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IQuestionsRepository {
    override suspend fun createQuestion(question: Question) = withContext(ioDispatcher) {
        remote.createQuestion(question).run {
            local.createQuestion(data ?: question)
        }
    }

    override suspend fun createQuestions(questions: List<Question>) = withContext(ioDispatcher) {
        remote.createQuestions(questions).run {
            local.createQuestions(data ?: questions)
        }
    }

    override suspend fun removeQuestion(question: Question) = withContext(ioDispatcher) {
        remote.removeQuestion(question).run {
            local.removeQuestion(question)
        }
    }

    override suspend fun removeQuestion(id: String) = withContext(ioDispatcher) {
        remote.removeQuestion(id).run {
            local.removeQuestion(id)
        }
    }

    override suspend fun getQuestion(id: String) = withContext(ioDispatcher) {
        remote.getQuestion(id).run {
            data?.let {
                local.createQuestion(it)
//                local.getQuestion(it.id) // Repetitive - done by above
            } ?: this
        }
    }

    override suspend fun getQuestions() = withContext(ioDispatcher) {
        remote.getQuestions().run {
            local.createQuestions(listData)
//            local.getQuestions() // Repetitive - done by above
        }
    }

    override suspend fun getObservableQuestions() = local.getObservableQuestions()
}