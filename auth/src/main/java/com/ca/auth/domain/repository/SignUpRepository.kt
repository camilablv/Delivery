package com.ca.auth.domain.repository

import com.google.firebase.auth.PhoneAuthOptions

interface SignUpRepository {
    fun verifyPhoneNumber(options: PhoneAuthOptions)
}