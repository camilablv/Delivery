package com.ca.auth.data.network

import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class AuthProvider {

    val auth = FirebaseAuth.getInstance()
    lateinit var verificationId: String
    lateinit var resendingToken: PhoneAuthProvider.ForceResendingToken

    fun credential(code: String) =
        PhoneAuthProvider.getCredential(verificationId, code)

    private val onVerificationStateChangedCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            TODO("Not yet implemented")
        }

        override fun onVerificationFailed(exception: FirebaseException) {
            TODO("Not yet implemented")
        }

        override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
            verificationId = id
            resendingToken = token
        }
    }

    fun verify(activity: Activity, phoneNumber: String) {
        val options = PhoneAuthOptions
            .newBuilder()
            .setPhoneNumber(phoneNumber)
            .setActivity(activity)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(onVerificationStateChangedCallbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun signIn(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = task.result?.user
                } else {

                }
            }
    }
}