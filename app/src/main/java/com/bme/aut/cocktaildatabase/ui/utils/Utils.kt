package com.bme.aut.cocktaildatabase.ui.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View?.show() {
    this?.let {
        it.visibility = View.VISIBLE
    }
}

fun View?.hide() {
    this?.let {
        it.visibility = View.GONE
    }
}

fun Activity?.hideSoftKeyboard() {
    this ?: return
    val view = this.currentFocus
    view?.let { v ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }
}