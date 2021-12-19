package com.example.cs394_hw_plantapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPlant(plant: Plant)

    @Query(value = "SELECT * FROM plant_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Plant>>

}