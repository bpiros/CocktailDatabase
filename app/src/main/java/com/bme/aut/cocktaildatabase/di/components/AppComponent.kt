package com.bme.aut.cocktaildatabase.di.components

import android.content.Context
import com.bme.aut.cocktaildatabase.di.modules.InteractorModule
import com.bme.aut.cocktaildatabase.di.modules.NetworkModule
import com.bme.aut.cocktaildatabase.di.modules.UIModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UIModule::class,
        NetworkModule::class,
        InteractorModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}