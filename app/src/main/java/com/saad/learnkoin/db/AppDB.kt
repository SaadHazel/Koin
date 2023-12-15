package com.saad.learnkoin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saad.learnkoin.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDB: RoomDatabase() {

    abstract fun AppDao(): AppDao

}