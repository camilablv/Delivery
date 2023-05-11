package com.ca.auth.presentation.signin

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.StateFlow

interface SignInViewModel {
    val phoneNumber: MutableState<String>
    val password: MutableState<String>
    val uiState: StateFlow<SignInViewState>
}