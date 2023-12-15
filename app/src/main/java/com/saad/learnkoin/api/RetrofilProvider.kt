package com.saad.learnkoin.api

object RetrofilProvider {
    val productApi = RetrofilHelper.getInstance().create(MyApi::class.java)
}