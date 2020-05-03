package com.bme.aut.cocktaildatabase.model

data class CocktailItemModel(
    val cocktail: Cocktail,
    var isAddedToFavourites: Boolean
)