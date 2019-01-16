package com.app.tigr.data.repository

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "conversations")
data class ConversationsEntity(

        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "data")
        val parsedData: String
)