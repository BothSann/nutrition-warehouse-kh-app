package com.nutritionwarehouse.shared.domain

import com.nutritionwarehouse.shared.Resources
import org.jetbrains.compose.resources.DrawableResource

enum class Country (
    val dialCode : Int,
    val code: String,
    val flag: DrawableResource
) {
    Cambodia(
        dialCode = 855,
        code = "KH",
        flag = Resources.Flag.Cambodia
    )
    , China(
        dialCode = 86,
        code = "CN",
        flag = Resources.Flag.China
    )
    , USA(
        dialCode = 1,
        code = "US",
        flag = Resources.Flag.USA
    )

}