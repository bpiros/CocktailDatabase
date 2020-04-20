package com.bme.aut.cocktaildatabase.interactor

import com.bme.aut.cocktaildatabase.interactor.events.GetCocktailDetailsEvent
import com.bme.aut.cocktaildatabase.interactor.events.GetCocktailsEvent
import com.bme.aut.cocktaildatabase.interactor.events.SearchCocktailEvent
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.network.CocktailApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class CocktailsInteractor @Inject constructor(private var cocktailApi: CocktailApi) {

    fun getCocktails() {
        val event = GetCocktailsEvent()

        try {
            val cocktails = ArrayList<Cocktail>()

            for (i in 'a' until 'z') {
                val response = cocktailApi.getCocktailsByLetter(i.toString())?.execute()

                if (response?.code() != 200) {
                    throw Exception("Result code is not 200")
                }

                response.body()?.drinks?.let { drinks ->
                    if (!drinks.isNullOrEmpty()) {
                        cocktails.addAll(drinks)
                    }
                }
            }

            EventBus.getDefault().post(event)
        } catch (e: java.lang.Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }

    }

    fun searchCocktail(searchTerm: String) {
        val event = SearchCocktailEvent()

        try {
            val response = cocktailApi.getCocktailsBySearchTerm(searchTerm)?.execute()

            if (response?.code() != 200) {
                throw Exception("Result code is not 200")
            }

            event.cocktails = response.body()?.drinks
            EventBus.getDefault().post(event)
        } catch (e: java.lang.Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }

    }

    fun getCocktailDetails(id: Int) {
        val event = GetCocktailDetailsEvent()
        try {
            val response = cocktailApi.getCocktailDetails(id)?.execute()

            if (response?.code() != 200) {
                throw Exception("Result code is not 200")
            }

            response.body()?.drinks?.let { drinks ->
                if (drinks.isNotEmpty()) {
                    event.cocktail = drinks[0]
                }
            }

            EventBus.getDefault().post(event)
        } catch (e: java.lang.Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }

    }

    fun getFavourites() {
        //TODO: get favourite id-s from database

        //TODO: mindegyikre meghívni a getCocktailDetails-t és postolni egy eventet igy fog frissulni a favourites lista
    }

}