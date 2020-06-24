package com.teamaad34.polls.data.source.local

import androidx.lifecycle.Transformations
import com.teamaad34.polls.data.TaskResult
import com.teamaad34.polls.data.TaskResult.Success
import com.teamaad34.polls.data.model.Question
import com.teamaad34.polls.data.source.IQuestionDataSource
import com.teamaad34.polls.data.source.local.dao.QuestionsDao

class QuestionLocalDataSource internal constructor(private val dao: QuestionsDao) :
    IQuestionDataSource {
    override suspend fun createQuestion(question: Question): TaskResult<Question> {
        dao.createQuestion(question)
        return Success(dao.getQuestion(question.id).question)
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
        Transformations.map(dao.getObservableQuestions()) {
            it.map { question ->
                question.question
            }
        }
}