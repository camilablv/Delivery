package com.ca.auth.domain.usecase

import com.ca.auth.domain.repository.SignUpRepository

class SignUpUseCase(val repository: SignUpRepository) {

    fun verifyPhoneNumber(phoneNumber: String) {
        repository.verifyPhoneNumber(phoneNumber)
    }
}