package com.bme.aut.cocktaildatabase.ui.utils

import android.view.View

fun View?.show() {
    this?.let{
        it.visibility = View.VISIBLE
    }
}

fun View?.hide() {
    this?.let{
        it.visibility = View.GONE
    }
}