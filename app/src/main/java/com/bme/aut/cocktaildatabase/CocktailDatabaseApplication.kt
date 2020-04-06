package com.bme.aut.cocktaildatabase

import android.app.Application
import com.bme.aut.cocktaildatabase.di.components.AppComponent
import com.bme.aut.cocktaildatabase.di.components.DaggerAppComponent

class CocktailDatabaseApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}