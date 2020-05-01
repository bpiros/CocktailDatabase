package com.bme.aut.cocktaildatabase.ui.favourites

import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.Screen

interface FavouritesScreen : Screen {

    fun removeFromFavourites(cocktailId: String?)

    fun updateFavourites(cocktail: Cocktail)

    fun updateFavourites(cocktails: List<Cocktail>)

    fun showCocktails()

    fun showDetails(cocktailId: String)

}