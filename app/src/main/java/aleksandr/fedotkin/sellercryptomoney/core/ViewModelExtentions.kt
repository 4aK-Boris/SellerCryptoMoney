package aleksandr.fedotkin.sellercryptomoney.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun ViewModel.runOnBackground(block: suspend () -> Unit): Job =
    viewModelScope.launch(Dispatchers.Default) {
        block()
    }

fun ViewModel.runOnIO(block: suspend () -> Unit): Job =
    viewModelScope.launch(Dispatchers.IO) {
        block()
    }