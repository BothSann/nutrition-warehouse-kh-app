package com.nutritionwarehouse.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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