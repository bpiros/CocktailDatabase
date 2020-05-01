package com.bme.aut.cocktaildatabase.di.modules

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsPresenter
import com.bme.aut.cocktaildatabase.ui.details.DetailsPresenter
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule() {

    @Provides
    @Singleton
    fun cocktailsPresenter(cocktailsInteractor: CocktailsInteractor) =
        CocktailsPresenter(cocktailsInteractor)

    @Provides
    @Singleton
    fun detailsPresenter(cocktailsInteractor: CocktailsInteractor) =
        DetailsPresenter(cocktailsInteractor)


    @Provides
    @Singleton
    fun favouritesPresenter(cocktailsInteractor: CocktailsInteractor) =
        FavouritesPresenter(cocktailsInteractor)

}