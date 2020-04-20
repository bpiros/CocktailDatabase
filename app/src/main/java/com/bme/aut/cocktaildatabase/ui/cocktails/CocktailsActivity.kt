package com.bme.aut.cocktaildatabase.ui.cocktails

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.details.DetailsActivity
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesActivity
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.show
import kotlinx.android.synthetic.main.activity_cocktails.*
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

    override fun showCocktails(cocktails: ArrayList<Cocktail>) {
        //TODO: show cocktails
    }

    override fun showDetails(cocktailId: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY, cocktailId)
        startActivity(intent)
    }

    override fun showSearchResults(cocktails: ArrayList<Cocktail>) {
        //TODO: show results
    }

    override fun showFavourites() {
        val intent = Intent(this, FavouritesActivity::class.java)
        startActivity(intent)
    }

    override fun startLoading() {
        progressbar?.show()
    }

    override fun endLoading() {
        progressbar?.hide()
    }

    override fun sayNoResults() {
        messageTextView?.text = getString(R.string.no_result)
        messageTextView?.show()
    }

    override fun showNetworkError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val KEY = "COCKTAILS_ACTIVITY"
    }

}