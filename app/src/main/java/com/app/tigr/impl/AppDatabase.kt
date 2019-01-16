package com.app.tigr.impl

import com.app.tigr.data.repository.ChatDao

interface AppDatabase {
    fun getDatabase(): ChatDao
}