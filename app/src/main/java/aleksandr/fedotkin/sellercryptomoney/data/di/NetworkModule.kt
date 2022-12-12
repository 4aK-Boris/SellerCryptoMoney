package aleksandr.fedotkin.sellercryptomoney.data.di

import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPI
import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPIImpl
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.KtorClient
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.Websockets
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureDefaultRequest
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureJson
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureLogging
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureTimeout
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins.configureWebSockets
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(OkHttp) {
            configureJson()
            configureLogging()
            configureDefaultRequest()
            configureTimeout()
            configureWebSockets()
        }
    }

    single {
        Websockets(client = get())
    }

    single {
        KtorClient(client = get())
    }

    singleOf(::NetworkAPIImpl) {
        bind<NetworkAPI>()
    }
}
