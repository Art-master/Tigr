package com.app.tigr.data.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface ChatDao {

    @Query(value = "SELECT dataRequest FROM conversations")
    fun getConversationsData(): String
}