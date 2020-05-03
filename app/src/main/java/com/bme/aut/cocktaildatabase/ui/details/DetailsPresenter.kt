package com.bme.aut.cocktaildatabase.ui.details

import com.bme.aut.cocktaildatabase.interactor.CocktailsInteractor
import com.bme.aut.cocktaildatabase.interactor.events.GetCocktailDetailsEvent
import com.bme.aut.cocktaildatabase.interactor.events.SavedToFavouritesEvent
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val executor: Executor,
    private val cocktailsInteractor: CocktailsInteractor
) :
    Presenter<DetailsScreen>() {

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showDetails(cocktail: Cocktail) {
        screen?.showDetails(cocktail)
    }

    fun showCocktails() {
        screen?.navigateToCocktails()
    }

    fun showFavourites() {
        screen?.navigateToFavourites()
    }

    fun navigateBack() {
        screen?.navigateBack()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onDetailsThread(event: GetCocktailDetailsEvent) {
        screen?.endLoading()
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showToast(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.cocktail == null) {
                    screen?.showToast("Something went wrong. Try it later.")
                } else {
                    screen?.showDetails(event.cocktail!!)
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onDetailsThread(event: SavedToFavouritesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showToast(event.throwable?.message.orEmpty())
            }
        } else {
            screen?.showToast("${event.cocktailName} added to favourites")
        }
    }
}