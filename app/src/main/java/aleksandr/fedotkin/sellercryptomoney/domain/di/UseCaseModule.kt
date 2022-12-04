package aleksandr.fedotkin.sellercryptomoney.domain.di

import aleksandr.fedotkin.sellercryptomoney.domain.usecases.ProductUseCase
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.PurchaseUseCase
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.SellerUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        SellerUseCase(sellerRepository = get())
    }

    factory {
        ProductUseCase(productRepository = get())
    }

    factory {
        PurchaseUseCase(purchaseRepository = get())
    }
}
