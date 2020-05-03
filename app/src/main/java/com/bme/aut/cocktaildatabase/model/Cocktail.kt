package com.bme.aut.cocktaildatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Cocktail(

    @PrimaryKey(autoGenerate = true)
    var databaseId: Int,

    @SerializedName("idDrink")
    val idDrink: String? = null,

    @SerializedName("strDrink")
    val strDrink: String? = null,

    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: String? = null,

    @SerializedName("strDrinkES")
    val strDrinkES: String? = null,

    @SerializedName("strDrinkDE")
    val strDrinkDE: String? = null,

    @SerializedName("strDrinkFR")
    val strDrinkFR: String? = null,

    @SerializedName("strDrinkZH-HANS")
    val strDrinkZHHANS: String? = null,

    @SerializedName("strDrinkZH-HANT")
    val strDrinkZHHANT: String? = null,

    @SerializedName("strTags")
    val strTags: String? = null,

    @SerializedName("strVideo")
    val strVideo: String? = null,

    @SerializedName("strCategory")
    val strCategory: String? = null,

    @SerializedName("strIBA")
    val strIBA: String? = null,

    @SerializedName("strAlcoholic")
    val strAlcoholic: String? = null,

    @SerializedName("strGlass")
    val strGlass: String? = null,

    @SerializedName("strInstructions")
    val strInstructions: String? = null,

    @SerializedName("strInstructionsES")
    val strInstructionsES: String? = null,

    @SerializedName("strInstructionsDE")
    val strInstructionsDE: String? = null,

    @SerializedName("strInstructionsFR")
    val strInstructionsFR: String? = null,

    @SerializedName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: String? = null,

    @SerializedName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: String? = null,

    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = null,

    @SerializedName("redient1")
    val redient1: String? = null,

    @SerializedName("redient2")
    val redient2: String? = null,

    @SerializedName("redient3")
    val redient3: String? = null,

    @SerializedName("redient4")
    val redient4: String? = null,

    @SerializedName("redient5")
    val redient5: String? = null,

    @SerializedName("redient6")
    val redient6: String? = null,

    @SerializedName("redient7")
    val redient7: String? = null,

    @SerializedName("redient8")
    val redient8: String? = null,

    @SerializedName("redient9")
    val redient9: String? = null,

    @SerializedName("redient10")
    val redient10: String? = null,

    @SerializedName("redient11")
    val redient11: String? = null,

    @SerializedName("redient12")
    val redient12: String? = null,

    @SerializedName("redient13")
    val redient13: String? = null,

    @SerializedName("redient14")
    val redient14: String? = null,

    @SerializedName("redient15")
    val redient15: String? = null,

    @SerializedName("strMeasure1")
    val strMeasure1: String? = null,

    @SerializedName("strMeasure2")
    val strMeasure2: String? = null,

    @SerializedName("strMeasure3")
    val strMeasure3: String? = null,

    @SerializedName("strMeasure4")
    val strMeasure4: String? = null,

    @SerializedName("strMeasure5")
    val strMeasure5: String? = null,

    @SerializedName("strMeasure6")
    val strMeasure6: String? = null,

    @SerializedName("strMeasure7")
    val strMeasure7: String? = null,

    @SerializedName("strMeasure8")
    val strMeasure8: String? = null,

    @SerializedName("strMeasure9")
    val strMeasure9: String? = null,

    @SerializedName("strMeasure10")
    val strMeasure10: String? = null,

    @SerializedName("strMeasure11")
    val strMeasure11: String? = null,

    @SerializedName("strMeasure12")
    val strMeasure12: String? = null,

    @SerializedName("strMeasure13")
    val strMeasure13: String? = null,

    @SerializedName("strMeasure14")
    val strMeasure14: String? = null,

    @SerializedName("strMeasure15")
    val strMeasure15: String? = null,

    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String? = null,

    @SerializedName("dateModified")
    val dateModified: String? = null

)