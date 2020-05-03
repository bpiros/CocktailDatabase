package com.bme.aut.cocktaildatabase.ui.cocktails

import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.Screen

interface CocktailsScreen : Screen {

    fun showCocktails(cocktails: List<Cocktail>, favourites: ArrayList<Cocktail>?)

    fun showDetails(cocktail: Cocktail)

    fun showSearchResults(cocktails: ArrayList<Cocktail>, favourites: ArrayList<Cocktail>?)

    fun showFavourites()

    fun sayNoResults()

}