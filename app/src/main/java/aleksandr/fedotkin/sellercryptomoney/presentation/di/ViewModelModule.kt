package aleksandr.fedotkin.sellercryptomoney.presentation.di

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.MainViewModel
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.ProductViewModel
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.PurchaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel() {
        MainViewModel(sellerUseCase = get(), errorHandler = get())
    }

    viewModel() {
        ProductViewModel(productUseCase = get(), errorHandler = get())
    }

    viewModel {
        PurchaseViewModel(purchaseUseCase = get(), errorHandler = get())
    }
}
