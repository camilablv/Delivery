package com.ca.auth.data.repository

import com.ca.auth.data.network.AuthProvider
import com.ca.auth.domain.repository.SignUpRepository
import com.google.firebase.auth.PhoneAuthOptions

class SignUpRepositoryImpl(
    private val authProvider: AuthProvider
) : SignUpRepository {

    override fun verifyPhoneNumber(options: PhoneAuthOptions) {
        authProvider.verify(options)
    }
}