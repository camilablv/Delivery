package com.ca.auth.presentation.signup

data class SignUpViewState(
    val phoneNumber: String = "",
    val password: String = "",
    val name: String = "",
    val email: String = "",
    val phoneNumberError: String? = null,
    val passwordError: String? = null,
    val emailError: String? = null,
    val signUpSuccessful: Boolean = false
)
