package com.example.cs394_hw_plantapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlantViewModel(application:Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Plant>>
    private val repository: PlantRepository
    init {
        val plantDao = PlantDatabase.getDatabase(application).plantDao()
        repository = PlantRepository(plantDao)
        readAllData = repository.readAllData

    }

    fun addPlant(plant:Plant){
        viewModelScope.launch (Dispatchers.IO){
            repository.addPlant(plant)
        }
    }
}