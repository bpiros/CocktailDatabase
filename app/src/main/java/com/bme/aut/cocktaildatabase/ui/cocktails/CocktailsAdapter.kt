package com.bme.aut.cocktaildatabase.ui.cocktails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.model.Cocktail


class CocktailsAdapter(
    private val cocktailsPresenter: CocktailsPresenter
) :
    RecyclerView.Adapter<CocktailViewHolder>() {

    private var data = ArrayList<Cocktail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.view_cocktail_item, parent, false)
        return CocktailViewHolder(itemView, cocktailsPresenter)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
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
}