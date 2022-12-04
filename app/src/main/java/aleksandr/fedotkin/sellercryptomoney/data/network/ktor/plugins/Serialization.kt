package aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

fun HttpClientConfig<*>.configureJson() {
    install(ContentNegotiation) {
        json()
    }
}

