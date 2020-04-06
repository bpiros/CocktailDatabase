package com.bme.aut.cocktaildatabase.di.modules

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.network.CocktailApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideCocktailsInteractor(cocktailApi: CocktailApi) = CocktailsInteractor(cocktailApi)

}