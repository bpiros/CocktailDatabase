package com.bme.aut.cocktaildatabase.ui.cocktails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.model.Cocktail
import javax.inject.Inject

class CocktailsActivity : AppCompatActivity(), CocktailsScreen {

    @Inject
    lateinit var cocktailPresenter: CocktailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_cocktails)

        init()
    }

    override fun onStart() {
        super.onStart()
        cocktailPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        cocktailPresenter.detachScreen()
    }

    private fun init() {
        //TODO: init ui elements
    }

    override fun showDetails(cocktailId: String) {
        //TODO: navigate to details screen
    }

    override fun showSearchResults(cocktails: ArrayList<Cocktail>) {
        //TODO: show results
    }

    override fun showFavourites() {
        //TODO: navigate to favourites screen
    }

    companion object {
        const val KEY = "COCKTAILS_ACTIVITY"
    }

}