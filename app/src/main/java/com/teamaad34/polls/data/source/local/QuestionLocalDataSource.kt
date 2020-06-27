package com.teamaad34.polls.data.source.local

import androidx.lifecycle.Transformations
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.TaskResult.Success
import com.teamaad34.polls.data.model.Question
import com.teamaad34.polls.data.source.IQuestionDataSource
import com.teamaad34.polls.data.source.local.dao.QuestionsDao

/**
 * Does CRUD(Create, Read, Update & Delete) operations in the local database with the help of
 * Room Dao
 */
class QuestionLocalDataSource internal constructor(private val dao: QuestionsDao) :
    IQuestionDataSource {
    override suspend fun createQuestion(question: Question): TaskResult<Question> {
        dao.createQuestion(question)
        return getQuestion(question.id)
    }

    override suspend fun createQuestions(questions: List<Question>): TaskResult<List<Question>> {
        dao.createQuestions(questions)
        return getQuestions()
    }

    override suspend fun removeQuestion(question: Question) = Success(dao.removeQuestion(question))

    override suspend fun removeQuestion(id: String) = Success(dao.removeQuestion(id))

    override suspend fun getQuestion(id: String) = Success(dao.getQuestion(id).question)

    override suspend fun getQuestions() = Success(dao.getQuestions().map { it.question })

    override suspend fun getObservableQuestions() =
        Transformations.map(dao.getObservableQuestions()) { qwc -> qwc.map { it.question } }
}