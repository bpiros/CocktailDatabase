package com.bme.aut.cocktaildatabase.ui.cocktails

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.interactor.events.GetCocktailsEvent
import com.bme.aut.cocktaildatabase.interactor.events.SearchCocktailEvent
import com.bme.aut.cocktaildatabase.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class CocktailsPresenter @Inject constructor(private val cocktailsInteractor: CocktailsInteractor) :
    Presenter<CocktailsScreen>() {

    override fun attachScreen(screen: CocktailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showCocktails() {
        screen?.startLoading()
        cocktailsInteractor.getCocktails()
    }

    fun showCocktailsSearchList(searchTerm: String) {
        screen?.startLoading()
        cocktailsInteractor.searchCocktail(searchTerm)
    }

    fun addToFavourites(cocktailId: String) {
        //TODO: implement add to favourites logic
    }

    fun removeFromFavourites(cocktailsId: String) {
        //TODO: implement remove from favourites logic
    }

    fun showFavourites() {
        screen?.showFavourites()
    }

    fun showDetailsOf(cocktailId: String) {
        screen?.showDetails(cocktailId)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetCocktailThread(event: GetCocktailsEvent) {
        screen?.endLoading()
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.cocktails == null) {
                    screen?.showNetworkError("Something went wrong. Try it later.")
                } else {
                    screen?.showCocktails(event.cocktails!!)
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSearchCocktailThread(event: SearchCocktailEvent) {
        screen?.endLoading()
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.cocktails == null || event.cocktails?.isEmpty() == true) {
                    screen?.sayNoResults()
                } else {
                    screen?.showSearchResults(event.cocktails!!)
                }
            }
        }
    }
}