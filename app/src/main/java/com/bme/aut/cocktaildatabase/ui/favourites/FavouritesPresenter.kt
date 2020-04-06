package com.bme.aut.cocktaildatabase.ui.favourites

import com.bme.aut.cocktaildatabase.ui.Presenter

class FavouritesPresenter : Presenter<FavouritesScreen>() {

    fun removeFromFavourites(cocktailId: String) {
        //TODO: remove it from db
        screen?.removeFromFavourites(cocktailId)
    }

    fun showToCocktails() {
        screen?.showToCocktails()
    }

    fun showToDetails(cocktailId: String) {
        screen?.showToDetails(cocktailId)
    }

}