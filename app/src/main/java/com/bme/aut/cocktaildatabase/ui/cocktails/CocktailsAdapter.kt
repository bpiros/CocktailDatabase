package com.bme.aut.cocktaildatabase.ui.cocktails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.model.CocktailItemModel


class CocktailsAdapter(
    private val cocktailsPresenter: CocktailsPresenter
) :
    RecyclerView.Adapter<CocktailViewHolder>() {

    private var data = ArrayList<CocktailItemModel>()

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


    fun updateData(cocktails: List<Cocktail>, favourites: ArrayList<Cocktail>? = null) {
        data.clear()
        data.addAll(createItemModels(cocktails, favourites))
        notifyDataSetChanged()
    }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    private fun createItemModels(
        cocktails: List<Cocktail>,
        favourites: ArrayList<Cocktail>?
    ): ArrayList<CocktailItemModel> {
        val result = ArrayList<CocktailItemModel>()
        cocktails.forEach { cocktail ->
            result.add(
                CocktailItemModel(
                    cocktail = cocktail,
                    isAddedToFavourites = isCocktailFavourite(cocktail, favourites)
                )
            )
        }
        return result
    }

    private fun isCocktailFavourite(cocktail: Cocktail, favourites: ArrayList<Cocktail>?): Boolean {
        favourites?.forEach { favourite ->
            if (favourite.idDrink == cocktail.idDrink) {
                return true
            }
        }
        return false
    }
}