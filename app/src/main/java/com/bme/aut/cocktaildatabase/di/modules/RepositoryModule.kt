package com.bme.aut.cocktaildatabase.di.modules

import com.bme.aut.cocktaildatabase.repository.CocktailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCocktailRepository(cocktailRepository: CocktailRepository): CocktailRepository

}