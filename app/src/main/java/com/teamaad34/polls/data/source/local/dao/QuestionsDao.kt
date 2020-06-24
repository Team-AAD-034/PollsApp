package com.teamaad34.polls.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.teamaad34.polls.data.model.Question
import com.teamaad34.polls.data.model.QuestionWithChoices

@Dao
interface QuestionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createQuestion(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createQuestions(questions: List<Question>)

    @Delete
    suspend fun removeQuestion(question: Question): Int

    @Query("DELETE FROM questions WHERE id = :id")
    suspend fun removeQuestion(id: String): Int

    @Transaction
    @Query("SELECT * FROM questions WHERE id = :id;")
    suspend fun getQuestion(id: String): QuestionWithChoices

    @Transaction
    @Query("SELECT * FROM questions;")
    suspend fun getQuestions(): List<QuestionWithChoices>

    @Transaction
    @Query("SELECT * FROM questions;")
    fun getObservableQuestions(): LiveData<List<QuestionWithChoices>>
}