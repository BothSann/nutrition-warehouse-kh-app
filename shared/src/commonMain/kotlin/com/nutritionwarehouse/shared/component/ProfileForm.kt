package com.nutritionwarehouse.shared.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileForm(
    modifier: Modifier = Modifier,
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    city: String,
    onCityChange: (String) -> Unit,
    postalCode: Int? = null,
    onPostalCodeChange: (Int?) -> Unit,
    address: String,
    onAddressChange: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 24.dp,
                vertical = 12.dp
            )
            .verticalScroll(state = rememberScrollState())
            .imePadding(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CustomTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            placeholder = "Virak",
            error = firstName.length !in 3 .. 20,
            enabled = true
        )
        CustomTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            placeholder = "Un",
            error = lastName.length !in 3 .. 20,
            enabled =  true
        )
        CustomTextField(
            value = email,
            onValueChange = {},
            placeholder = "virakun@gmail.com",
            enabled = false
        )
        CustomTextField(
            value = city,
            onValueChange = onCityChange,
            placeholder = "Phnom Penh",
            error = city.length !in 3 .. 20,
            enabled = true,
        )
        CustomTextField(
            value = postalCode?.toString() ?: "",
            onValueChange = { newValue ->
                onPostalCodeChange(newValue.toIntOrNull())
            },
            placeholder = "Postal Code",
            error = postalCode == null || postalCode < 1000 || postalCode > 99999,
            enabled = true
        )
        CustomTextField(
            value = address,
            onValueChange = onAddressChange,
            placeholder = "Street 123, Building 456",
            error = address.length !in 3 .. 50,
            enabled = true
        )
        CustomTextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            placeholder = "012 345 678",
            error = phoneNumber.length !in 9 .. 15,
            enabled = true
        )
    }
}