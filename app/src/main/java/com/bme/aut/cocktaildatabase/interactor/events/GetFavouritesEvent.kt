package com.bme.aut.cocktaildatabase.interactor.events

import com.bme.aut.cocktaildatabase.model.Cocktail

data class GetFavouritesEvent(
    var cocktail: Cocktail? = null,
    var throwable: Throwable? = null
)