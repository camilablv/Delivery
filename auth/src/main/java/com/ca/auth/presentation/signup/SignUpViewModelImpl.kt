package com.ca.auth.presentation.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ca.auth.data.network.AuthProvider
import com.ca.auth.domain.AuthStateChangedCallbacks
import com.google.firebase.auth.PhoneAuthOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

class SignUpViewModelImpl(
    private val authProvider: AuthProvider
): ViewModel(), SignUpViewModel, AuthStateChangedCallbacks {

    init {
        authProvider.setupCallbacks(this)
    }

    override val phoneNumber = mutableStateOf("+380633804050")
    override val password = mutableStateOf("")
    override val email = mutableStateOf("")
    override val name = mutableStateOf("")

    private val _uiState = MutableStateFlow(SignUpViewState())
    override val uiState: StateFlow<SignUpViewState>
        get() = _uiState

    val callbacks = authProvider.onVerificationStateChangedCallbacks

    fun verifyPhoneNumber(options: PhoneAuthOptions) {
        authProvider.verify(options)
    }

    fun signIn(code: String) {
        val credential = authProvider.credential(code)
        authProvider.signIn(credential)
    }

    override fun onVerificationCompleted() {
        _uiState.value = _uiState.value.copy(signUpSuccessful = true)
    }

    override fun onVerificationFailed(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun onTimeout() {
        TODO("Not yet implemented")
    }

    override fun codeSent() {
        _uiState.value
    }
}