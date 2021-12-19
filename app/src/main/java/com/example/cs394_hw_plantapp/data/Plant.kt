package com.example.cs394_hw_plantapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URI

@Entity(tableName = "plant_table")
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val family_name:String,
    val scientific_name:String,
    val image:Int
)