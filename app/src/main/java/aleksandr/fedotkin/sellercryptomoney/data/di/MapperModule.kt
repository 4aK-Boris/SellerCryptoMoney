package aleksandr.fedotkin.sellercryptomoney.data.di

import aleksandr.fedotkin.sellercryptomoney.data.mappers.SellerMapper
import aleksandr.fedotkin.sellercryptomoney.data.mappers.ProductMapper
import aleksandr.fedotkin.sellercryptomoney.data.mappers.PurchaseMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val mapperModule = module {

    factoryOf(::SellerMapper)

    factoryOf(::ProductMapper)

    factoryOf(::PurchaseMapper)
}
