package aleksandr.fedotkin.sellercryptomoney.presentation.di

import aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels.MainViewModel
import aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels.ProductViewModel
import aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels.PurchaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel() {
        MainViewModel(sellerUseCase = get())
    }

    viewModel() {
        ProductViewModel(productUseCase = get())
    }

    viewModel {
        PurchaseViewModel(purchaseUseCase = get())
    }
}