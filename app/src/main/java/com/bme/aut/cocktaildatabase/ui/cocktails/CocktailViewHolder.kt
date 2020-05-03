package com.bme.aut.cocktaildatabase.ui.cocktails

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.show
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.view_cocktail_item.view.*

class CocktailViewHolder(itemView: View, private val cocktailsPresenter: CocktailsPresenter) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var cocktail: Cocktail
    private var isAddedToFavourites = false

    fun bind(cocktail: Cocktail) {
        this.cocktail = cocktail

        itemView.cocktialTitleTextView?.text = cocktail.strDrink
        itemView.favouriteBackgroundImageView?.setOnClickListener {
            if (isAddedToFavourites) {
                cocktailsPresenter.removeFromFavourites(cocktail)
                itemView.favouriteImageView?.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                isAddedToFavourites = false
            } else {
                cocktailsPresenter.addToFavourites(cocktail)
                itemView.favouriteImageView?.setImageResource(R.drawable.ic_favorite_black_24dp)
                isAddedToFavourites = true
            }
        }

        Glide
            .with(itemView)
            .asBitmap()
            .load(cocktail.strDrinkThumb)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                    itemView.placeholder?.show()
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    itemView.placeholder?.hide()
                    itemView.cocktailImageView.setImageBitmap(resource)
                }

            })


    }

}