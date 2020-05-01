package com.bme.aut.cocktaildatabase.repository

import androidx.room.*
import com.bme.aut.cocktaildatabase.model.Cocktail

@Dao
interface CocktailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCocktail(cocktail: Cocktail)

    @Query("select * from Cocktail")
    fun getAllCocktail(): List<Cocktail>

    @Delete
    fun deleteCocktail(cocktail: Cocktail)

}