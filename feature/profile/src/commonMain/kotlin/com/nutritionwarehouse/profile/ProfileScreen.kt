package com.nutritionwarehouse.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nutritionwarehouse.shared.Surface
import com.nutritionwarehouse.shared.component.ProfileForm
import com.nutritionwarehouse.shared.domain.Country

@Composable
fun ProfileScreen() {

    var country by remember { mutableStateOf(Country.Cambodia) }
    Box(
        modifier = Modifier
            .systemBarsPadding()
            .background(Surface)
    ) {
        ProfileForm(
            country = country,
            onCountrySelect = { selectedCountry ->
                country = selectedCountry
            },
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


}