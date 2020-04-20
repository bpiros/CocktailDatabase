package com.bme.aut.cocktaildatabase.network

import com.bme.aut.cocktaildatabase.model.DrinksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CocktailApi {

    /**
     * Get one cocktail with its details
     *
     * @param i The cocktail id
     * @return Call<DrinksResponse>
    </DrinksResponse> */
    @GET("lookup.php")
    fun getCocktailDetails(@Query("i") cocktailId: Int?): Call<DrinksResponse?>?

    /**
     * Get cocktails by first letter
     *
     * @param f The first letter of cocktail s name
     * @return Call<DrinksResponse>
    </DrinksResponse> */
    @GET("search.php")
    fun getCocktailsByLetter(@Query("f") letter: String?): Call<DrinksResponse?>?

    /**
     * Get cocktails by search term
     *
     * @param s The search term, a part of a cocktail name
     * @return Call<DrinksResponse>
    </DrinksResponse> */
    @GET("search.php")
    fun getCocktailsBySearchTerm(@Query("s") searchTerm: String?): Call<DrinksResponse?>?

}