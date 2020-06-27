package com.teamaad34.polls.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.teamaad34.polls.data.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(user: User)

    @Delete
    suspend fun deleteUser(user: User): Int

    /**
     * @param cacheId id used to achieve local uniqueness in a sqlite db
     */
    @Query("SELECT * FROM user WHERE cacheId = :cacheId;")
    suspend fun getUser(cacheId: Int): User

    /**
     * @param id should be a FirebaseUser uid
     */
    @Query("SELECT * FROM user WHERE id = :id;")
    suspend fun getUser(id: String): User

    /**
     * @see getUser
     */
    @Query("SELECT * FROM user WHERE cacheId = :cacheId;")
    fun getObservableUser(cacheId: Int): LiveData<User>

    /**
     * @see getUser
     */
    @Query("SELECT * FROM user WHERE id = :id;")
    fun getObservableUser(id: String): LiveData<User>
}