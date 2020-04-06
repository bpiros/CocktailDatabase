package com.bme.aut.cocktaildatabase.ui.cocktails

import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.Presenter

class CocktailsPresenter : Presenter<CocktailsScreen>() {

    fun showCocktailsSearchList(searchTerm: String) {
        var searchResults = ArrayList<Cocktail>()
        //TODO: implement search
        screen?.showSearchResults(searchResults)
    }

    fun addToFavourites(cocktailId: String) {
        //TODO: implement add to favourites logic
    }

    fun removeFromFavourites(cocktailsId: String) {
        //TODO: implement remove from favourites logic
    }

    fun showToFavourites() {
        screen?.showFavourites()
    }

    fun showToDetails(cocktailId: String) {
        screen?.showDetails(cocktailId)
    }

}