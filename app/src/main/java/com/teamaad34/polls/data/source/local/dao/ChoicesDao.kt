package com.teamaad34.polls.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.teamaad34.polls.data.model.Choice

@Dao
interface ChoicesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createChoice(choice: Choice)

    @Delete
    suspend fun removeChoice(choice: Choice): Int

    @Query("DELETE FROM choices WHERE id = :id")
    suspend fun removeChoice(id: String): Int

    @Query("SELECT * FROM choices WHERE id = :id;")
    suspend fun getChoice(id: String): Choice

    @Query("SELECT * FROM choices WHERE questionId = :questionId;")
    suspend fun getChoices(questionId: String): List<Choice>

    @Query("SELECT * FROM choices WHERE questionId = :questionId;")
    fun getObservableChoices(questionId: String): LiveData<List<Choice>>
}