package com.bme.aut.cocktaildatabase.repository

import com.bme.aut.cocktaildatabase.model.Cocktail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailRepository @Inject constructor(
    private var database: CocktailDatabase,
    private var cocktailDao: CocktailDao
) {

    private val uiScope = CoroutineScope(Dispatchers.Main)
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun saveToFavourite(cocktail: Cocktail, completion: () -> Unit) {
        ioScope.launch {
            cocktailDao.insertCocktail(cocktail)
        }
        completion()
    }

    fun getAllFavourite(completion: (cocktails: List<Cocktail>?) -> Unit) {
        uiScope.launch {
            val cocktails = withContext(Dispatchers.IO) {
                cocktailDao.getAllCocktail()
            }
            completion(cocktails)
        }
    }

    fun deleteFromFavourites(cocktail: Cocktail, completion: () -> Unit) {
        ioScope.launch {
            cocktailDao.deleteCocktail(cocktail)
            completion()
        }
    }

}