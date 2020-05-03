package com.bme.aut.cocktaildatabase.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.bme.aut.cocktaildatabase.R
import kotlinx.android.synthetic.main.view_toolbar.view.*

class ToolbarView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    init {
        View.inflate(context, R.layout.view_toolbar, this)
    }

    fun bind(onSearchClick: (searchTerm: String) -> Unit, onTitleClick: () -> Unit) {
        searchImageView?.setOnClickListener {
            onSearchClick(searchEditText?.text.toString())
        }
        titleTextView?.setOnClickListener {
            onTitleClick()
        }
    }

}
