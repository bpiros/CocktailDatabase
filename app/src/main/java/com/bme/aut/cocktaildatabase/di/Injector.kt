package com.bme.aut.cocktaildatabase.di

import android.app.Activity
import com.bme.aut.cocktaildatabase.CocktailDatabaseApplication
import com.bme.aut.cocktaildatabase.di.components.AppComponent

val Activity.injector: AppComponent
    get() {
        return (this.application as CocktailDatabaseApplication).appComponent
    }