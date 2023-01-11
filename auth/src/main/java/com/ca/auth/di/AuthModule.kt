package com.ca.auth.di

import com.ca.auth.data.network.AuthProvider
import com.ca.auth.data.repository.SignUpRepositoryImpl
import com.ca.auth.domain.repository.SignUpRepository
import com.ca.auth.presentation.signin.SignInViewModelImpl
import com.ca.auth.presentation.signup.SignUpViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    // singleton SignUpViewModelImpl

    viewModel { SignInViewModelImpl() }
    viewModel { SignUpViewModelImpl(get()) }
    factory<SignUpRepository> { SignUpRepositoryImpl(get()) }
    factory { AuthProvider() }
}

