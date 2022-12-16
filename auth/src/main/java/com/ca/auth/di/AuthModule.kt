package com.ca.auth.di

import com.ca.auth.data.repository.SignUpRepositoryImpl
import com.ca.auth.domain.repository.SignUpRepository
import com.ca.auth.domain.usecase.SignInUseCase
import com.ca.auth.domain.usecase.SignUpUseCase
import com.ca.auth.presentation.signin.SignInViewModelImpl
import com.ca.auth.presentation.signup.SignUpViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { SignInViewModelImpl(get()) }
    viewModel { SignUpViewModelImpl(get()) }
    factory { SignInUseCase() }
    factory { SignUpUseCase(get()) }
    factory<SignUpRepository> { SignUpRepositoryImpl() }
}

