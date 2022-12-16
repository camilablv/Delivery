package com.ca.auth.domain.repository

interface SignUpRepository {
    fun verifyPhoneNumber(phoneNumber: String)
}