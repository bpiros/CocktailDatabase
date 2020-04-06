package com.bme.aut.cocktaildatabase.ui.details

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsActivity
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
        //TODO: get data from bundles
        //TODO: init ui elements
    }

    override fun showCocktails() {
        val intent = Intent(this, CocktailsActivity::class.java)
        startActivity(intent)
    }

    override fun showFavourites() {
        //TODO: navigate to favourites screen
    }

    override fun navigateBack() {
        onBackPressed()
    }

    companion object {
        const val KEY = "DETAILS_ACTIVITY"
    }

}