package com.bme.aut.cocktaildatabase.di.modules

import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsPresenter
import com.bme.aut.cocktaildatabase.ui.details.DetailsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule() {

    @Provides
    @Singleton
    fun cocktailsPresenter() = CocktailsPresenter()

    @Provides
    @Singleton
    fun detailsPresenter() = DetailsPresenter()

}