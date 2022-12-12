package aleksandr.fedotkin.sellercryptomoney.presentation.di

import aleksandr.fedotkin.sellercryptomoney.core.ErrorHandler
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val errorModule = module {
    singleOf(::ErrorHandler)
}
