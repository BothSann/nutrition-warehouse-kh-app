package com.nutritionwarehouse.auth

import ContentWithMessageBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mmk.kmpauth.firebase.google.GoogleButtonUiContainerFirebase
import com.nutritionwarehouse.auth.component.GoogleButton
import com.nutritionwarehouse.shared.Alpha
import com.nutritionwarehouse.shared.BebaNeueFont
import com.nutritionwarehouse.shared.FontSize
import com.nutritionwarehouse.shared.Surface
import com.nutritionwarehouse.shared.SurfaceBrand
import com.nutritionwarehouse.shared.SurfaceError
import com.nutritionwarehouse.shared.SurfaceSuccess
import com.nutritionwarehouse.shared.TextPrimary
import com.nutritionwarehouse.shared.TextSecondary
import com.nutritionwarehouse.shared.TextWhite
import org.koin.compose.viewmodel.koinViewModel
import rememberMessageBarState

@Composable
fun AuthScreen() {
    val viewModel = koinViewModel <AuthViewModel>()
    val messageBarState = rememberMessageBarState()
    var loadingState by remember { mutableStateOf(false) }

    Scaffold { padding->
        ContentWithMessageBar(
            modifier = Modifier
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                ),
            messageBarState = messageBarState,
            errorMaxLines = 2,
            contentBackgroundColor = Surface,
            errorContainerColor = SurfaceError,
            errorContentColor = TextWhite,
            successContainerColor = SurfaceSuccess,
            successContentColor = TextWhite,
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Column (
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Nutrition Warehouse",
                        textAlign = TextAlign.Center,
                        fontFamily = BebaNeueFont(),
                        fontSize = FontSize.EXTRA_LARGE,
                        color = TextSecondary
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(Alpha.HALF),
                        text = "Sign in to continue",
                        textAlign = TextAlign.Center,
                        fontSize = FontSize.EXTRA_REGULAR,
                        color = TextPrimary
                    )
                }
                GoogleButtonUiContainerFirebase(
                    linkAccount = false,
                    onResult = {result ->
                        result.onSuccess { user ->
                            viewModel.createCustomer(
                                user = user,
                                onSuccess = {messageBarState.addSuccess("Authentication successful!")},
                                onError = { error ->
                                    messageBarState.addError(error)
                                }
                            )
                            loadingState = false
                        }.onFailure { error ->
                            if(error.message?.contains("A network error") == true) {
                                messageBarState.addError("Network error. Please try again later.")
                            } else if (error.message?.contains("id token is null") == true) {
                                messageBarState.addError("Google sign-in failed. Please try again.")
                            } else {
                                messageBarState.addError(error.message ?: "An error occurred during Google sign-in.")
                            }
                            loadingState = false
                        }
                    }
                ) {
                    GoogleButton (
                        loading = loadingState,
                        onClick = {
                            loadingState = true
                            this@GoogleButtonUiContainerFirebase.onClick()
                        },
                    )
                }
            }
        }
    }
}