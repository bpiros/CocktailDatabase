package com.bme.aut.cocktaildatabase.interactor.events

import com.bme.aut.cocktaildatabase.model.Cocktail

data class SearchCocktailEvent(
    var cocktails: ArrayList<Cocktail>? = null,
    var throwable: Throwable? = null
)