package com.bme.aut.cocktaildatabase.di.modules

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsPresenter
import com.bme.aut.cocktaildatabase.ui.details.DetailsPresenter
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule() {

    @Provides
    @Singleton
    fun cocktailsPresenter(executor: Executor, cocktailsInteractor: CocktailsInteractor) =
        CocktailsPresenter(executor, cocktailsInteractor)

    @Provides
    @Singleton
    fun detailsPresenter(executor: Executor, cocktailsInteractor: CocktailsInteractor) =
        DetailsPresenter(executor, cocktailsInteractor)


    @Provides
    @Singleton
    fun favouritesPresenter(executor: Executor, cocktailsInteractor: CocktailsInteractor) =
        FavouritesPresenter(executor, cocktailsInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

}