package aleksandr.fedotkin.sellercryptomoney.data.di

import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPI
import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPIImpl
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.KtorClient
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureDefaultRequest
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureJson
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureLogging
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureTimeout
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(Android) {
            configureJson()
            configureLogging()
            configureDefaultRequest()
            configureTimeout()
        }
    }

    single {
        KtorClient(client = get())
    }

    singleOf(::NetworkAPIImpl) {
        bind<NetworkAPI>()
    }
}
