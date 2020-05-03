package com.bme.aut.cocktaildatabase.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bme.aut.cocktaildatabase.model.Cocktail

@Database(
    entities = [
        Cocktail::class
    ], version = 1, exportSchema = false
)

@TypeConverters()
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}