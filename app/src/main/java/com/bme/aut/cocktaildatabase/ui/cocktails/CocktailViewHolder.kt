package com.bme.aut.cocktaildatabase.ui.cocktails

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.model.CocktailItemModel
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.show
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.view_cocktail_item.view.*

class CocktailViewHolder(itemView: View, private val cocktailsPresenter: CocktailsPresenter) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var model: CocktailItemModel

    fun bind(model: CocktailItemModel) {
        this.model = model

        itemView.cocktialTitleTextView?.text = model.cocktail.strDrink
        itemView.favouriteBackgroundImageView?.setOnClickListener {
            if (this.model.isAddedToFavourites) {
                cocktailsPresenter.removeFromFavourites(this.model.cocktail)
                itemView.favouriteImageView?.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                this.model.isAddedToFavourites = false
            } else {
                cocktailsPresenter.addToFavourites(this.model.cocktail)
                itemView.favouriteImageView?.setImageResource(R.drawable.ic_favorite_black_24dp)
                this.model.isAddedToFavourites = true
            }
        }

        Glide
            .with(itemView)
            .asBitmap()
            .load(this.model.cocktail.strDrinkThumb)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                    itemView.placeholder?.show()
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    itemView.placeholder?.hide()
                    itemView.cocktailImageView.setImageBitmap(resource)
                }

            })


        if (this.model.isAddedToFavourites) {
            itemView.favouriteImageView?.setImageResource(R.drawable.ic_favorite_black_24dp)
        } else {
            itemView.favouriteImageView?.setImageResource(R.drawable.ic_favorite_border_black_24dp)
        }

        itemView.cocktailImageView?.setOnClickListener {
            cocktailsPresenter.showDetailsOf(this.model.cocktail)
        }

        itemView.placeholder?.setOnClickListener {
            cocktailsPresenter.showDetailsOf(this.model.cocktail)
        }

        itemView.cocktialTitleTextView?.setOnClickListener {
            cocktailsPresenter.showDetailsOf(this.model.cocktail)
        }

    }

}