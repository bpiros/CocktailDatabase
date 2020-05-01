package com.bme.aut.cocktaildatabase.interactor.events

data class RemovedFromFavouritesEvent(
    var cocktailName: String? = null,
    var throwable: Throwable? = null
)