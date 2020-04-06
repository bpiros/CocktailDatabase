package com.bme.aut.cocktaildatabase.ui.details

import com.bme.aut.cocktaildatabase.ui.Presenter

class DetailsPresenter : Presenter<DetailsScreen>() {

    fun showCocktails() {
        screen?.showCocktails()
    }

    fun showFavourites() {
        screen?.showFavourites()
    }

    fun navigateBack() {
        screen?.navigateBack()
    }

}