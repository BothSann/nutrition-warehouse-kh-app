package com.nutritionwarehouse.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.nutritionwarehouse.shared.BebaNeueFont
import com.nutritionwarehouse.shared.FontSize
import com.nutritionwarehouse.shared.IconPrimary
import com.nutritionwarehouse.shared.Resources
import com.nutritionwarehouse.shared.Surface
import com.nutritionwarehouse.shared.TextPrimary
import com.nutritionwarehouse.shared.component.PrimaryButton
import com.nutritionwarehouse.shared.component.ProfileForm
import com.nutritionwarehouse.shared.domain.Country
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navigateBack: () -> Unit,
) {

    var country by remember { mutableStateOf(Country.Cambodia) }
    Scaffold (
        containerColor = Surface,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Profile",
                        fontFamily = BebaNeueFont(),
                        fontSize = FontSize.LARGE,
                        color = TextPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            painter = painterResource(Resources.Icon.BackArrow),
                            contentDescription = "Back Icon",
                            tint = IconPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Surface,
                    scrolledContainerColor = Surface,
                    titleContentColor = TextPrimary,
                    navigationIconContentColor = IconPrimary,
                    actionIconContentColor = IconPrimary
                )
            )
        }
    ) { padding ->
        Column (
            modifier = Modifier
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                )
                .padding(
                    horizontal = 24.dp,
                )
                .padding(
                    top = 12.dp,
                    bottom = 24.dp,
                )
        ) {
            ProfileForm(
                modifier = Modifier.weight(1f),
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
            Spacer(modifier = Modifier.height(12.dp))
            PrimaryButton(
                text = "Update",
                icon = Resources.Icon.Checkmark,
                onClick = {},
            )
        }
    }


}