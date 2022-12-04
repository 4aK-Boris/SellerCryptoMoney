package aleksandr.fedotkin.sellercryptomoney.data.di

import aleksandr.fedotkin.sellercryptomoney.data.repositories.SellerRepositoryImpl
import aleksandr.fedotkin.sellercryptomoney.data.repositories.ProductRepositoryImpl
import aleksandr.fedotkin.sellercryptomoney.data.repositories.PurchaseRepositoryImpl
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.ProductRepository
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.PurchaseRepository
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.SellerRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {

    factoryOf(::SellerRepositoryImpl) {
        bind<SellerRepository>()
    }

    factoryOf(::ProductRepositoryImpl) {
        bind<ProductRepository>()
    }

    factoryOf(::PurchaseRepositoryImpl) {
        bind<PurchaseRepository>()
    }
}
