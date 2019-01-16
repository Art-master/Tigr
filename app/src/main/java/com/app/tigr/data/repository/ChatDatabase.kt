package com.app.tigr.data.repository

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.app.tigr.common.Constants.Companion.DATABASE_FILE_NAME
import com.app.tigr.impl.AppDatabase

@Database(entities = [ConversationsEntity::class], version = 1)
abstract class ChatDatabase : RoomDatabase(), AppDatabase {
    abstract override fun getDatabase(): ChatDao

    companion object {
        fun getAppDataBase(context: Context): AppDatabase? {
            synchronized(ChatDatabase::class) {
                return Room.databaseBuilder(
                        context.applicationContext,
                        ChatDatabase::class.java,
                        DATABASE_FILE_NAME)
                        .build()
            }
        }
    }
}