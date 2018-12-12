package com.app.tigr.common

/**
 * Description a system messages for users
 */
interface Message {
    enum class ERROR {
        INIT_DATABASE
    }

    enum class WARNING

    enum class INFO

    companion object {
        const val TYPE = "tigr app type"
        const val EMPTY = ""
    }
}