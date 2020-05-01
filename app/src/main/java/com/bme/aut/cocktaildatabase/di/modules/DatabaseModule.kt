package com.bme.aut.cocktaildatabase.di.modules

import android.content.Context
import androidx.room.Room
import com.bme.aut.cocktaildatabase.repository.CocktailDao
import com.bme.aut.cocktaildatabase.repository.CocktailDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(context: Context): CocktailDatabase {
        val databaseName = "CocktailDB_Database"
        return Room.databaseBuilder(context, CocktailDatabase::class.java, databaseName).build()
    }

    @Singleton
    @Provides
    fun provideCocktailDao(database: CocktailDatabase): CocktailDao {
        return database.cocktailDao()
    }

}