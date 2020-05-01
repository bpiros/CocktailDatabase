package com.bme.aut.cocktaildatabase.di.components

import android.content.Context
import com.bme.aut.cocktaildatabase.di.modules.*
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsActivity
import com.bme.aut.cocktaildatabase.ui.details.DetailsActivity
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UIModule::class,
        NetworkModule::class,
        InteractorModule::class,
        RepositoryModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: CocktailsActivity)
    fun inject(activity: DetailsActivity)
    fun inject(activity: FavouritesActivity)

}