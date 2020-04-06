package com.bme.aut.cocktaildatabase.ui.cocktails

import com.bme.aut.cocktaildatabase.model.Cocktail

interface CocktailsScreen {

    fun showDetails(cocktailId: String)

    fun showSearchResults(cocktails: ArrayList<Cocktail>)

    fun showFavourites()

}