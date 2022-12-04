package aleksandr.fedotkin.sellercryptomoney.core.di

import aleksandr.fedotkin.sellercryptomoney.data.di.mapperModule
import aleksandr.fedotkin.sellercryptomoney.data.di.networkModule
import aleksandr.fedotkin.sellercryptomoney.data.di.repositoryModule
import aleksandr.fedotkin.sellercryptomoney.domain.di.useCaseModule
import aleksandr.fedotkin.sellercryptomoney.presentation.di.viewModelModule
import org.koin.dsl.module

val appModule = module {
    includes(viewModelModule, useCaseModule, mapperModule, networkModule, repositoryModule)
}
