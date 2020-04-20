package com.bme.aut.cocktaildatabase.ui.details

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsActivity
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesActivity
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.show
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsScreen {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_details)

        init()
    }

    override fun onStart() {
        super.onStart()
        detailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        detailsPresenter.detachScreen()
    }

    private fun init() {
        val cocktailId = intent.getIntExtra(DetailsActivity.KEY, 0)
        detailsPresenter.showDetails(cocktailId)

        //TODO: init ui elements
    }

    override fun showDetails(cocktail: Cocktail) {
        //TODO: show details on page
    }

    override fun showCocktails() {
        val intent = Intent(this, CocktailsActivity::class.java)
        startActivity(intent)
    }

    override fun showFavourites() {
        val intent = Intent(this, FavouritesActivity::class.java)
        startActivity(intent)
    }

    override fun navigateBack() {
        onBackPressed()
    }

    override fun startLoading() {
        progressbar.show()
    }

    override fun endLoading() {
        progressbar.hide()
    }

    override fun showNetworkError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val KEY = "DETAILS_ACTIVITY"
    }

}