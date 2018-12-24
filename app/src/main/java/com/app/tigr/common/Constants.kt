package com.app.tigr.common

class Constants {

    companion object {
        const val DATABASE_FILE_NAME = "holidays.db"
        const val FONT_ASSETS_DIRECTORY = "fonts/"
        const val SETTINGS_FILE_NAME = "tigr_app_settings"
    }

    enum class Keys constructor(private val value: String)


    interface Network{
        companion object {
            const val BASE_URL = "https://api.vk.com/"
            const val VERSION_API = "5.92"
        }
    }
}

