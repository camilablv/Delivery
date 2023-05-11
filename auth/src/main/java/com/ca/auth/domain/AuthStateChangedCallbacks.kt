package com.ca.auth.domain

interface AuthStateChangedCallbacks {
    fun onVerificationCompleted()
    fun onVerificationFailed(errorMessage: String)
    fun onTimeout()
    fun codeSent()
}