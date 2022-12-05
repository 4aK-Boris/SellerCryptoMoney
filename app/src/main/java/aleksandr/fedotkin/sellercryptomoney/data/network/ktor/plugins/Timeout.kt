package aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins

import aleksandr.fedotkin.sellercryptomoney.core.TIMEOUT
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout



fun HttpClientConfig<*>.configureTimeout() {
    install(HttpTimeout) {
        requestTimeoutMillis = TIMEOUT
    }
}

