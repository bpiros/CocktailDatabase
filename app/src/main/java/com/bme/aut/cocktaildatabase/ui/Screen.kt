package com.bme.aut.cocktaildatabase.ui

interface Screen {

    fun startLoading()

    fun endLoading()

    fun showToast(message: String)

}