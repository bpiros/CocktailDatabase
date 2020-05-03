package com.bme.aut.cocktaildatabase.ui.favourites

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.view_favourite_item.view.*

class FavouriteViewHolder(itemView: View, private val favouritesPresenter: FavouritesPresenter) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(cocktail: Cocktail) {

        itemView.favouriteTitleTextView?.text = cocktail.strDrink

        Glide
            .with(itemView)
            .asBitmap()
            .load(cocktail.strDrinkThumb)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                    itemView.placeholder?.hide()
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    itemView.placeholder?.hide()
                    itemView.cocktailImageView?.setImageBitmap(resource)
                }

            })

        itemView.deleteImageView?.setOnClickListener {
            favouritesPresenter.removeFromFavourites(cocktail)
        }

        itemView.placeholder?.setOnClickListener {
            favouritesPresenter.showToDetails(cocktail)
        }

        itemView.cocktailImageView?.setOnClickListener {
            favouritesPresenter.showToDetails(cocktail)
        }

        itemView.favouriteTitleTextView?.setOnClickListener {
            favouritesPresenter.showToDetails(cocktail)
        }

    }
}