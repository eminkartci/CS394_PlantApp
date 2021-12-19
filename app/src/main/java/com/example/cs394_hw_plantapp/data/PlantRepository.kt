package com.example.cs394_hw_plantapp.data

import androidx.lifecycle.LiveData

class PlantRepository(private val plantDao: PlantDao) {

    val readAllData: LiveData<List<Plant>> = plantDao.readAllData()

    suspend fun addPlant(plant:Plant){
        plantDao.addPlant(plant)
    }

}