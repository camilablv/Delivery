package com.ca.auth.presentation.signup

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.StateFlow

interface SignUpViewModel {
    val phoneNumber: MutableState<String>
    val password: MutableState<String>
    val email: MutableState<String>
    val name: MutableState<String>
    val uiState: StateFlow<SignUpViewState>
}