package com.nutritionwarehouse.profile

import ContentWithMessageBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.nutritionwarehouse.shared.BebaNeueFont
import com.nutritionwarehouse.shared.FontSize
import com.nutritionwarehouse.shared.IconPrimary
import com.nutritionwarehouse.shared.Resources
import com.nutritionwarehouse.shared.Surface
import com.nutritionwarehouse.shared.SurfaceSuccess
import com.nutritionwarehouse.shared.TextPrimary
import com.nutritionwarehouse.shared.component.InfoCard
import com.nutritionwarehouse.shared.component.LoadingCard
import com.nutritionwarehouse.shared.component.PrimaryButton
import com.nutritionwarehouse.shared.component.ProfileForm
import com.nutritionwarehouse.shared.util.DisplayResult
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import rememberMessageBarState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navigateBack: () -> Unit,
) {

    val viewModel = koinViewModel<ProfileViewModel>()
    val screenReady = viewModel.screenReady
    val screenState = viewModel.screenState
    val messageBarState = rememberMessageBarState()
    val isFormValid = viewModel.isFormValid

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
        ContentWithMessageBar(
            contentBackgroundColor = Surface,
            modifier = Modifier
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                ),
            messageBarState = messageBarState,
            errorMaxLines = 2,
            successContentColor = Surface,
            successContainerColor = SurfaceSuccess
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 24.dp,
                    )
                    .padding(
                        top = 12.dp,
                        bottom = 24.dp,
                    )
                    .imePadding(),
            ) {
                screenReady.DisplayResult(
                    onLoading = { LoadingCard(modifier = Modifier.fillMaxSize()) },
                    onSuccess = {state->
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            ProfileForm(
                                modifier = Modifier.weight(1f),
                                country = screenState.country,
                                onCountrySelect = viewModel::updateCountry,
                                firstName = screenState.firstName,
                                onFirstNameChange = viewModel::updateFirstName,
                                lastName = screenState.lastName,
                                onLastNameChange = viewModel::updateLastName,
                                email = screenState.email,
                                phoneNumber = screenState.phoneNumber?.number ?: "",
                                onPhoneNumberChange = viewModel::updatePhoneNumber,
                                city = screenState.city,
                                onCityChange = viewModel::updateCity,
                                postalCode = screenState.postalCode,
                                onPostalCodeChange = viewModel::updatePostalCode,
                                address = screenState.address,
                                onAddressChange = viewModel::updateAddress,
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            PrimaryButton(
                                text = "Update",
                                icon = Resources.Icon.Checkmark,
                                enabled = isFormValid,
                                onClick = {
                                    viewModel.updateCustomer(
                                        onSuccess = {
                                            messageBarState.addSuccess("Profile updated successfully")
                                        },
                                        onError = { message ->
                                            messageBarState.addError("Error updating profile: $message")
                                        }
                                    )
                                },
                            )
                        }
                    },
                    onError = { errorMessage->
                        InfoCard(
                            image = Resources.Image.Cat,
                            title = "Oops!",
                            subtitle = errorMessage ?: "Something went wrong. Please try again later.",
                        )
                    }
                )
            }
        }
    }
}