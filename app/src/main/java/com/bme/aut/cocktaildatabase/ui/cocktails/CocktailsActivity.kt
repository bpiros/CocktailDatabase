package com.bme.aut.cocktaildatabase.ui.cocktails

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.details.DetailsActivity
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesActivity
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.hideSoftKeyboard
import com.bme.aut.cocktaildatabase.ui.utils.show
import kotlinx.android.synthetic.main.activity_cocktails.*
import javax.inject.Inject

class CocktailsActivity : AppCompatActivity(), CocktailsScreen {

    @Inject
    lateinit var cocktailPresenter: CocktailsPresenter

    private lateinit var adapter: CocktailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_cocktails)
    }

    override fun onStart() {
        super.onStart()
        cocktailPresenter.attachScreen(this)
        init()
    }

    override fun onStop() {
        super.onStop()
        cocktailPresenter.detachScreen()
    }

    private fun init() {
        adapter = CocktailsAdapter(cocktailPresenter)

        cocktailsRecyclerview?.layoutManager = LinearLayoutManager(this)
        cocktailsRecyclerview?.adapter = adapter

        toolbar?.bind(
            onSearchClick = { searchTerm ->
                if (searchTerm.isNotBlank()) {
                    cocktailPresenter.showCocktailsSearchList(searchTerm)
                } else {
                    cocktailPresenter.showCocktails()
                }
                hideSoftKeyboard()
            },
            onTitleClick = {
                cocktailPresenter.showCocktails()
                hideSoftKeyboard()
            }
        )

        bottomNavigationView?.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_favourites -> {
                    cocktailPresenter.showFavourites()
                }
            }
            true
        }

        bottomNavigationView?.selectedItemId = R.id.action_cocktails
        cocktailPresenter.showCocktails()
    }

    override fun showCocktails(cocktails: List<Cocktail>, favourites: ArrayList<Cocktail>?) {
        messageTextView?.hide()
        adapter.updateData(cocktails, favourites)
    }

    override fun showDetails(cocktail: Cocktail) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY, cocktail)
        startActivity(intent)
    }

    override fun showSearchResults(
        cocktails: ArrayList<Cocktail>,
        favourites: ArrayList<Cocktail>?
    ) {
        messageTextView?.hide()
        adapter.clearData()
        adapter.updateData(cocktails, favourites)
    }

    override fun showFavourites() {
        val intent = Intent(this, FavouritesActivity::class.java)
        startActivity(intent)
    }

    override fun startLoading() {
        try {
            adapter.clearData()
        } catch (e: Exception) {
        }
        progressbar?.show()
    }

    override fun endLoading() {
        progressbar?.hide()
    }

    override fun sayNoResults() {
        messageTextView?.text = getString(R.string.no_result)
        messageTextView?.show()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val KEY = "COCKTAILS_ACTIVITY"
    }

}