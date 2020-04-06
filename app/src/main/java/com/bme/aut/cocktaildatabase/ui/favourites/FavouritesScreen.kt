package com.bme.aut.cocktaildatabase.ui.favourites

interface FavouritesScreen {

    fun removeFromFavourites(cocktailId: String)

    fun showToCocktails()

    fun showToDetails(cocktailId: String)

}