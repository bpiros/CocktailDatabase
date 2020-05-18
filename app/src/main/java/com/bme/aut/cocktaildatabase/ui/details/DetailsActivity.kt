package com.bme.aut.cocktaildatabase.ui.details

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bme.aut.cocktaildatabase.R
import com.bme.aut.cocktaildatabase.di.injector
import com.bme.aut.cocktaildatabase.model.Cocktail
import com.bme.aut.cocktaildatabase.ui.cocktails.CocktailsActivity
import com.bme.aut.cocktaildatabase.ui.favourites.FavouritesActivity
import com.bme.aut.cocktaildatabase.ui.utils.hide
import com.bme.aut.cocktaildatabase.ui.utils.show
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject


class DetailsActivity : AppCompatActivity(), DetailsScreen {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_details)
    }

    override fun onStart() {
        super.onStart()
        detailsPresenter.attachScreen(this)

        init()
    }

    override fun onStop() {
        super.onStop()
        detailsPresenter.detachScreen()
    }

    private fun init() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "SEE_DETAILS")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "See details")
        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

        val cocktail = intent.getParcelableExtra<Cocktail>(DetailsActivity.KEY)
        detailsPresenter.showDetails(cocktail)

        val navigationIcon = toolbar?.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar?.setNavigationOnClickListener {
            detailsPresenter.navigateBack()
        }

    }

    override fun showDetails(cocktail: Cocktail) {
        toolbar?.title = "Details of ${cocktail.strDrink}"

        Glide
            .with(this)
            .asBitmap()
            .load(cocktail.strDrinkThumb)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                    placeholderImageView?.hide()
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    placeholderImageView?.hide()
                    cocktailImageView?.setImageBitmap(resource)
                }

            })


        cocktail.strIBA?.let {
            ibaTypeTeytView?.show()
            ibaTypeTeytView?.text = "IBA type: ${it}"
        }


        cocktail.strCategory?.let { addTag(it) }
        cocktail.strAlcoholic?.let { addTag(it) }
        cocktail.strTags?.let {
            val tags = it.split(",").toTypedArray()
            tags.forEach { tag ->
                addTag(tag)
            }
        }

        cocktail.strIngredient1?.let { addIngredient(it) }
        cocktail.strIngredient2?.let { addIngredient(it) }
        cocktail.strIngredient3?.let { addIngredient(it) }
        cocktail.strIngredient4?.let { addIngredient(it) }
        cocktail.strIngredient5?.let { addIngredient(it) }
        cocktail.strIngredient6?.let { addIngredient(it) }
        cocktail.strIngredient7?.let { addIngredient(it) }
        cocktail.strIngredient8?.let { addIngredient(it) }
        cocktail.strIngredient9?.let { addIngredient(it) }
        cocktail.strIngredient10?.let { addIngredient(it) }
        cocktail.strIngredient11?.let { addIngredient(it) }
        cocktail.strIngredient12?.let { addIngredient(it) }
        cocktail.strIngredient13?.let { addIngredient(it) }
        cocktail.strIngredient14?.let { addIngredient(it) }
        cocktail.strIngredient15?.let { addIngredient(it) }

        preaprationTextView?.text = cocktail.strInstructions

    }

    override fun navigateToCocktails() {
        val intent = Intent(this, CocktailsActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToFavourites() {
        val intent = Intent(this, FavouritesActivity::class.java)
        startActivity(intent)
    }

    override fun navigateBack() {
        onBackPressed()
    }

    override fun startLoading() {
        progressbar.show()
    }

    override fun endLoading() {
        progressbar.hide()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun addTag(text: String) {
        val view = TextView(this)
        view.layoutParams = LinearLayout.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT
        )
        view.setPadding(20, 10, 20, 10)

        view.text = text
        view.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
        view.background = getDrawable(R.drawable.background_tag)

        tagLinearLayout?.addView(view)
    }

    private fun addIngredient(text: String) {
        ingredientsTextView?.show()
        val view = TextView(this)
        view.layoutParams = ViewGroup.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT
        )

        view.text = "- $text"
        ingredientsLinearLayout?.addView(view)
    }

    companion object {
        const val KEY = "DETAILS_ACTIVITY"
    }

}