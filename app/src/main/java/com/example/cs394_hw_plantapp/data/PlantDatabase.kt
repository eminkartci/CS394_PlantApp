package com.example.cs394_hw_plantapp.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Plant::class], version = 1, exportSchema = false)
abstract class PlantDatabase:RoomDatabase() {

    abstract fun plantDao() : PlantDao

    companion object{
        @Volatile
        private var INSTANCE: PlantDatabase? = null

        fun getDatabase(context: Context): PlantDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java,
                    "plant_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}