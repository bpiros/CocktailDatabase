package com.bme.aut.cocktaildatabase.interactor

import com.bme.aut.cocktaildatabase.interactor.events.*
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.network.CocktailApi
import com.bme.aut.cocktaildatabase.repository.CocktailRepository
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class CocktailsInteractor @Inject constructor(
    private var cocktailApi: CocktailApi,
    private var cocktailRepository: CocktailRepository
) {

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

            event.cocktails = cocktails.toList()
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

    fun getFavourites(callback: (favourites: ArrayList<Cocktail>?) -> Unit) {
        cocktailRepository.getAllFavourite { cocktails ->
            if (cocktails == null) {
                callback(null)
            } else {
                callback(ArrayList(cocktails))
            }
            EventBus.getDefault().post(GetFavouritesEvent(cocktails = cocktails))
        }
    }

    fun deleteFromFavourites(cocktail: Cocktail) {
        cocktailRepository.deleteFromFavourites(cocktail) {
            EventBus.getDefault().post(
                RemovedFromFavouritesEvent(
                    cocktailName = cocktail.strDrink,
                    cocktailId = cocktail.idDrink
                )
            )
        }

    }

    fun saveToFavourites(cocktail: Cocktail) {
        cocktailRepository.saveToFavourite(cocktail) {
            EventBus.getDefault().post(SavedToFavouritesEvent(cocktailName = cocktail.strDrink))
        }
    }

}