package com.bme.aut.cocktaildatabase.ui.favourites

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsActivity
import com.bme.aut.cocktaildatabase.ui.details.DetailsActivity
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.show
import kotlinx.android.synthetic.main.activity_favourites.*
import javax.inject.Inject

class FavouritesActivity : AppCompatActivity(), FavouritesScreen {

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_favourites)

        init()
    }

    override fun onStart() {
        super.onStart()
        favouritesPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        favouritesPresenter.detachScreen()
    }

    private fun init() {
        //TODO: init ui elements
    }

    override fun removeFromFavourites(cocktailId: String) {
        //TODO: update adapter, remove the cocktail from list
    }

    override fun updateFavourites(cocktail: Cocktail) {
        //TODO: update list with cocktail
    }

    override fun showCocktails() {
        val intent = Intent(this, CocktailsActivity::class.java)
        startActivity(intent)
    }

    override fun showDetails(cocktailId: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY, cocktailId)
        startActivity(intent)
    }

    override fun startLoading() {
        progressbar?.show()
    }

    override fun endLoading() {
        progressbar?.hide()
    }

    override fun showNetworkError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val KEY = "FAVOURITES_ACTIVITY"
    }

}