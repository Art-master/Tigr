package com.app.tigr.common

class Constants {

    companion object {
        const val DATABASE_FILE_NAME = "holidays.db"
        const val FONT_ASSETS_DIRECTORY = "fonts/"
        const val SETTINGS_FILE_NAME = "tigr_app_settings"
        const val APP_LANGUAGE = 0 //RUS
    }

    enum class Keys constructor(value: String){
        USER_ID("com.app.tigr.user.id"),
        PEER_ID("com.app.tigr.peer.id"),
        MESSAGE("com.app.tigr.message"),
        MESSAGE_SENT("com.app.tigr.message.sent")
    }


    interface Network{
        companion object {
            const val BASE_URL = "https://api.vk.com/"
            const val VERSION_API = "5.92"
            const val TEST_MODE = 1
        }
    }
}

