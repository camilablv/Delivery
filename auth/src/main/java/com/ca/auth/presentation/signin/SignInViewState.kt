package com.ca.auth.presentation.signin

data class SignInViewState(
    val phoneNumber: String = "",
    val password: String = "",
    val phoneNumberError: String? = null,
    val passwordError: String? = null,
    val signInSuccessful: Boolean = false
)
