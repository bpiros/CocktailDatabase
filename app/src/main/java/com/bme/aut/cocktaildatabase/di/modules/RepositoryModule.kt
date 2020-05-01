package com.bme.aut.cocktaildatabase.di.modules

import com.bme.aut.cocktaildatabase.repository.CocktailDao
import com.bme.aut.cocktaildatabase.repository.CocktailDatabase
import com.bme.aut.cocktaildatabase.repository.CocktailRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCocktailRepository(database: CocktailDatabase, cocktailDao: CocktailDao) =
        CocktailRepository(
            database = database,
            cocktailDao = cocktailDao
        )

}