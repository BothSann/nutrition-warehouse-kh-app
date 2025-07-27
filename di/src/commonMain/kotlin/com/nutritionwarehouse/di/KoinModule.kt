package com.nutritionwarehouse.di

import com.nutritionwarehouse.auth.AuthViewModel
import com.nutritionwarehouse.data.CustomerRepositoryImpl
import com.nutritionwarehouse.data.domain.CustomerRepository
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    single <CustomerRepository> { CustomerRepositoryImpl() }
    viewModelOf(::AuthViewModel)
}


fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }
}