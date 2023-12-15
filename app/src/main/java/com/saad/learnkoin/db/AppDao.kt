package com.saad.learnkoin.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saad.learnkoin.models.Product

@Dao
interface AppDao {
    @Insert
    suspend fun insertData(data: Product)

    @Query("Select * from products")
    fun getData(): LiveData<List<Product>>
}