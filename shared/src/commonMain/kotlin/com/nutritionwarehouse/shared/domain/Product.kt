package com.nutritionwarehouse.shared.domain

import androidx.compose.ui.graphics.Color
import com.nutritionwarehouse.shared.CategoryBlue
import com.nutritionwarehouse.shared.CategoryGreen
import com.nutritionwarehouse.shared.CategoryPurple
import com.nutritionwarehouse.shared.CategoryRed
import com.nutritionwarehouse.shared.CategoryYellow
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val title: String,
    val description: String,
    val thumbnail: String,
    val category: String,
    val flavors: List<String>? = null,
    val weight: Int? = null,
    val price: Double,
    val isPopular: Boolean = false,
    val isDiscounted: Boolean = false,
    val isNew: Boolean = false,
)

enum class ProductCategory(
    val title: String,
    val color: Color,
) {
    PROTEIN(
        title = "Protein",
        color = CategoryYellow
    ),
    CREATINE(
        title = "Creatine",
        color = CategoryBlue
    ),
    PRE_WORKOUT(
        title = "Pre-Workout",
        color = CategoryGreen
    ),
    GAINER(
        title = "Gainer",
        color = CategoryPurple
    ),
    Accessories(
        title = "Accessories",
        color = CategoryRed
    ),
}
