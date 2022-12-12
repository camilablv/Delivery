package com.ca.auth.presentation.signin

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInViewModelImpl : SignInViewModel {

    override val phoneNumber = mutableStateOf("")
    override val password = mutableStateOf("")

    private val _uiState = MutableStateFlow(SignInViewState())
    override val uiState: StateFlow<SignInViewState> = _uiState
}