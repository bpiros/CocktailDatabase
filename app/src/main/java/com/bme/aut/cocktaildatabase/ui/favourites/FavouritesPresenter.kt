package com.bme.aut.cocktaildatabase.ui.favourites

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.interactor.events.GetFavouritesEvent
import com.bme.aut.cocktaildatabase.interactor.events.RemovedFromFavouritesEvent
import com.bme.aut.cocktaildatabase.model.Cocktail
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

    fun removeFromFavourites(cocktail: Cocktail) {
        cocktailsInteractor.deleteFromFavourites(cocktail)
        screen?.removeFromFavourites(cocktail.idDrink)
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
                screen?.showToast(event.throwable?.message.orEmpty())
            }
        } else {
            if (event.cocktails != null) {
                screen?.showToast("Something went wrong.")
            } else {
                screen?.updateFavourites(event.cocktails!!)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFavouritesThread(event: RemovedFromFavouritesEvent) {
        screen?.endLoading()
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showToast(event.throwable?.message.orEmpty())
            }
        } else {
            screen?.showToast("${event.cocktailName} removed from favourites")
        }
    }

}