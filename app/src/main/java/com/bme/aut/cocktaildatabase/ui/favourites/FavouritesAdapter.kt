package com.bme.aut.cocktaildatabase.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.model.Cocktail

class FavouritesAdapter(
    private val favouritesPresenter: FavouritesPresenter
) :
    RecyclerView.Adapter<FavouriteViewHolder>() {

    private var data = ArrayList<Cocktail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.view_favourite_item, parent, false)
        return FavouriteViewHolder(itemView, favouritesPresenter)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(cocktails: List<Cocktail>) {
        data.clear()
        data.addAll(cocktails)
        notifyDataSetChanged()
    }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    fun removeCocktail(cocktailId: String) {

        val foundCocktail = data.find { cocktail -> cocktail.idDrink == cocktailId }
        val position = data.indexOf(foundCocktail)
        data.remove(foundCocktail)
        notifyItemRemoved(position)
    }

}