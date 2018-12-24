package com.app.tigr.impl

import com.app.tigr.data.network.VkApi

interface AppNetwork {
    fun connect(): VkApi?
}