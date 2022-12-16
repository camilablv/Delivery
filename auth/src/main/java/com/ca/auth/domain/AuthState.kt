package com.ca.auth.domain

sealed class AuthState {
    object None: AuthState()
    object onSuccess : AuthState()
    object onFail : AuthState()
    object onCodeSent : AuthState()
}
