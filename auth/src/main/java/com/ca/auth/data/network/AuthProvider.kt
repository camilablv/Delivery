package com.ca.auth.data.network

import com.ca.auth.domain.AuthStateChangedCallbacks
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider

class AuthProvider {

    val auth = FirebaseAuth.getInstance()
    lateinit var verificationId: String
    lateinit var resendingToken: PhoneAuthProvider.ForceResendingToken
    lateinit var authStateChangedCallbacks: AuthStateChangedCallbacks

    val onVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                authStateChangedCallbacks.onVerificationCompleted()
            }

            override fun onVerificationFailed(exception: FirebaseException) {
                authStateChangedCallbacks.onVerificationFailed(exception.message!!)
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                verificationId = id
            }
        }

    fun setupCallbacks(callbacks: AuthStateChangedCallbacks) {
        authStateChangedCallbacks = callbacks
    }

    fun credential(code: String) =
        PhoneAuthProvider.getCredential(verificationId, code)

    fun verify(options: PhoneAuthOptions) = PhoneAuthProvider.verifyPhoneNumber(options)

    fun signIn(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = task.result?.user
                    authStateChangedCallbacks.onVerificationCompleted()
                } else {
                    authStateChangedCallbacks.onVerificationFailed(task.exception?.message!!)
                }
            }
    }
}