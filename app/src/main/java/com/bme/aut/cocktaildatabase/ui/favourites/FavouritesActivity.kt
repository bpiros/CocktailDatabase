package com.bme.aut.cocktaildatabase.ui.favourites

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

    private lateinit var adapter: FavouritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_favourites)
    }

    override fun onStart() {
        super.onStart()
        favouritesPresenter.attachScreen(this)

        init()
    }

    override fun onStop() {
        super.onStop()
        favouritesPresenter.detachScreen()
    }

    private fun init() {
        adapter = FavouritesAdapter(favouritesPresenter)

        cocktailsRecyclerview?.adapter = adapter
        cocktailsRecyclerview?.layoutManager = LinearLayoutManager(this)

        bottomNavigationView?.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_cocktails -> {
                    favouritesPresenter.navigateToCocktails()
                }
            }
            true
        }

        bottomNavigationView?.selectedItemId = R.id.action_favourites

        favouritesPresenter.showFavourites()
    }

    override fun removeFromFavourites(cocktailId: String?) {
        cocktailId?.let {
            adapter.removeCocktail(cocktailId)
        }
    }

    override fun updateFavourites(cocktails: List<Cocktail>) {
        adapter.clearData()
        adapter.updateData(cocktails)
    }

    override fun navigateToCocktails() {
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

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val KEY = "FAVOURITES_ACTIVITY"
    }

}