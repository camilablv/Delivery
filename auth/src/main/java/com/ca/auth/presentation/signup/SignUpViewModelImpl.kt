package com.ca.auth.presentation.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignUpViewModelImpl: ViewModel(), SignUpViewModel {

    override val phoneNumber = mutableStateOf("")
    override val password = mutableStateOf("")
    override val email = mutableStateOf("")
    override val name = mutableStateOf("")

    private val _uiState = MutableStateFlow(SignUpViewState())
    override val uiState: StateFlow<SignUpViewState>
        get() = _uiState
}