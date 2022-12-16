package com.ca.auth.presentation.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ca.auth.domain.usecase.SignUpUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignUpViewModelImpl(
    private val signUpUseCase: SignUpUseCase
): ViewModel(), SignUpViewModel {

    override val phoneNumber = mutableStateOf("+380633804050")
    override val password = mutableStateOf("")
    override val email = mutableStateOf("")
    override val name = mutableStateOf("")

    private val _uiState = MutableStateFlow(SignUpViewState())
    override val uiState: StateFlow<SignUpViewState>
        get() = _uiState

    fun verify(phoneNumber: String) {
        signUpUseCase.verifyPhoneNumber(phoneNumber)
    }
}