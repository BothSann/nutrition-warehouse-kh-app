package com.nutritionwarehouse.shared

import nutritionwarehouse.shared.generated.resources.Res
import nutritionwarehouse.shared.generated.resources.plus
import nutritionwarehouse.shared.generated.resources.minus
import nutritionwarehouse.shared.generated.resources.log_in
import nutritionwarehouse.shared.generated.resources.log_out
import nutritionwarehouse.shared.generated.resources.unlock
import nutritionwarehouse.shared.generated.resources.search
import nutritionwarehouse.shared.generated.resources.user
import nutritionwarehouse.shared.generated.resources.check
import nutritionwarehouse.shared.generated.resources.edit
import nutritionwarehouse.shared.generated.resources.menu
import nutritionwarehouse.shared.generated.resources.back_arrow
import nutritionwarehouse.shared.generated.resources.right_arrow
import nutritionwarehouse.shared.generated.resources.shopping_cart
import nutritionwarehouse.shared.generated.resources.vertical_menu
import nutritionwarehouse.shared.generated.resources.weight
import nutritionwarehouse.shared.generated.resources.grid
import nutritionwarehouse.shared.generated.resources.dollar
import nutritionwarehouse.shared.generated.resources.map_pin
import nutritionwarehouse.shared.generated.resources.close
import nutritionwarehouse.shared.generated.resources.book
import nutritionwarehouse.shared.generated.resources.cambodia
import nutritionwarehouse.shared.generated.resources.cat
import nutritionwarehouse.shared.generated.resources.checkmark_image
import nutritionwarehouse.shared.generated.resources.china
import nutritionwarehouse.shared.generated.resources.delete
import nutritionwarehouse.shared.generated.resources.home
import nutritionwarehouse.shared.generated.resources.shopping_cart_image
import nutritionwarehouse.shared.generated.resources.google_logo
import nutritionwarehouse.shared.generated.resources.paypal_logo
import nutritionwarehouse.shared.generated.resources.usa


object Resources {
    object Icon{
        val Plus = Res.drawable.plus
        val Minus = Res.drawable.minus
        val SignIn = Res.drawable.log_in
        val SignOut = Res.drawable.log_out
        val Unlock = Res.drawable.unlock
        val Search = Res.drawable.search
        val Person = Res.drawable.user
        val Checkmark = Res.drawable.check
        val Edit = Res.drawable.edit
        val Menu = Res.drawable.menu
        val BackArrow = Res.drawable.back_arrow
        val RightArrow = Res.drawable.right_arrow
        val Home = Res.drawable.home
        val ShoppingCart = Res.drawable.shopping_cart
        val Categories = Res.drawable.grid
        val Dollar = Res.drawable.dollar
        val MapPin = Res.drawable.map_pin
        val Close = Res.drawable.close
        val Book = Res.drawable.book
        val VerticalMenu = Res.drawable.vertical_menu
        val Delete = Res.drawable.delete
        val Weight = Res.drawable.weight
    }
    object Image{
        val ShoppingCart = Res.drawable.shopping_cart_image
        val Checkmark = Res.drawable.checkmark_image
        val Cat = Res.drawable.cat
        val GoogleLogo = Res.drawable.google_logo
        val PayPalLogo = Res.drawable.paypal_logo
    }

    object Flag {
        val China = Res.drawable.china
        val Cambodia = Res.drawable.cambodia
        val USA = Res.drawable.usa
    }
}