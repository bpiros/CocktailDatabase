package com.bme.aut.cocktaildatabase.ui.favourites

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.interactor.events.GetFavouritesEvent
import com.bme.aut.cocktaildatabase.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class FavouritesPresenter @Inject constructor(private val cocktailsInteractor: CocktailsInteractor) :
    Presenter<FavouritesScreen>() {

    override fun attachScreen(screen: FavouritesScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showFavourites() {
        screen?.startLoading()

        cocktailsInteractor.getFavourites()
    }

    fun removeFromFavourites(cocktailId: String) {
        //TODO: remove it from db
        screen?.removeFromFavourites(cocktailId)
    }

    fun showToCocktails() {
        screen?.showCocktails()
    }

    fun showToDetails(cocktailId: String) {
        screen?.showDetails(cocktailId)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFavouritesThread(event: GetFavouritesEvent) {
        screen?.endLoading()
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.cocktail == null) {
                    screen?.showNetworkError("Something went wrong.")
                } else {
                    screen?.updateFavourites(event.cocktail!!)
                }
            }
        }
    }

}