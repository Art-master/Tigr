package com.app.tigr.common

class Constants {

    companion object {
        const val PROJECT_DIR = "com.app.tigr"
        const val DATABASE_FILE_NAME = "tigr.db"
        const val FONT_ASSETS_DIRECTORY = "fonts/"
        const val SETTINGS_FILE_NAME = "tigr_app_settings"
        const val APP_LANGUAGE = 0 //RUS
    }

    enum class Keys constructor(val value: String) {
        USER_ID("$PROJECT_DIR.user.id"),
        PEER_ID("$PROJECT_DIR.peer.id"),
        MESSAGE("$PROJECT_DIR.text"),
        REQUEST_DATA("$PROJECT_DIR.request.data"),
        REQUEST_NEW_MESSAGE("$PROJECT_DIR.request.new.message"),
    }

    enum class Actions constructor(val value: String) {
        NEW_MESSAGE("$PROJECT_DIR.action.new.message"),
    }

    interface Network{
        companion object {
            const val BASE_URL = "https://api.vk.com/"
            const val VERSION_API = "5.92"
            const val TEST_MODE = 1 // 1 - yes
            const val LONG_POLL_VERSION = 3
        }
    }
}

