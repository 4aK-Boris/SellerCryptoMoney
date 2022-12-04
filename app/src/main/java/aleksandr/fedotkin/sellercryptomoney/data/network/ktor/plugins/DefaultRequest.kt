package aleksandr.fedotkin.sellercryptomoney.data.network.ktor.plugins

import aleksandr.fedotkin.sellercryptomoney.core.BASE_URL
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLBuilder
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom

private val defaultHeaders: MutableMap<String, String> = mutableMapOf()

fun HttpClientConfig<*>.configureDefaultRequest() {
    defaultRequest {
        url.takeFrom(URLBuilder().takeFrom(BASE_URL).apply {
            encodedPath += url.encodedPath
        })
        headers.clear()
        defaultHeaders.forEach {
            headers.append(it.key, it.value)
        }
    }
}
