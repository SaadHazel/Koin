package com.saad.learnkoin.db

import android.content.Context
import androidx.room.Room

object DataBaseBuilder {
    private var INSTANCE: AppDB? = null

    fun getInstance(context: Context): AppDB {
        synchronized(this) {
            return INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }
    }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDB::class.java,
            "QRScanner"
        ).build()
}