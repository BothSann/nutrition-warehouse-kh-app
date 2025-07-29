package com.nutritionwarehouse.profile

import androidx.compose.runtime.Composable
import com.nutritionwarehouse.shared.component.ProfileForm

@Composable
fun ProfileScreen(
) {
    ProfileForm(
        firstName = "",
        onFirstNameChange = {},
        lastName = "",
        onLastNameChange = {},
        email = "",
        phoneNumber = "",
        onPhoneNumberChange = {},
        city = "",
        onCityChange = {},
        postalCode = null,
        onPostalCodeChange = {},
        address = "",
        onAddressChange = {},
    )
}