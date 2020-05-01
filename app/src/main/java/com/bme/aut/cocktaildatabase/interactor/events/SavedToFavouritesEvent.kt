package com.bme.aut.cocktaildatabase.interactor.events

data class SavedToFavouritesEvent(
    var cocktailName: String? = null,
    var throwable: Throwable? = null
)