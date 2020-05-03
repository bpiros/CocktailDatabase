package com.bme.aut.cocktaildatabase.interactor.events

data class RemovedFromFavouritesEvent(
    var cocktailId: String? = null,
    var cocktailName: String? = null,
    var throwable: Throwable? = null
)