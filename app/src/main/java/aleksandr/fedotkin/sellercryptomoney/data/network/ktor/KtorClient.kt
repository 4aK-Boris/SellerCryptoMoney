package aleksandr.fedotkin.sellercryptomoney.data.network.ktor

import aleksandr.fedotkin.sellercryptomoney.domain.common.BadRequest
import aleksandr.fedotkin.sellercryptomoney.domain.common.InternalServerError
import aleksandr.fedotkin.sellercryptomoney.domain.common.NoInternet
import aleksandr.fedotkin.sellercryptomoney.domain.common.Unauthorized
import aleksandr.fedotkin.sellercryptomoney.domain.common.UnknownNetworkException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import java.nio.channels.UnresolvedAddressException

class KtorClient(private val client: HttpClient) {

    suspend inline fun <reified T : Any> call(request: () -> HttpResponse): T = try {
        val response = request()
        if (!response.status.isSuccess()) {
            handleError(response)
        }
        response.body()
    } catch (ex: UnresolvedAddressException) {
        throw NoInternet()
    } catch (e: Exception) {
        throw NoInternet()
    }

    suspend fun postRequest(url: String, body: Any): HttpResponse {
        return client.post(urlString = url) {
            setBody(body)
        }
    }

    suspend fun getRequest(url: String, parameters: Map<String, Any>): HttpResponse {
        return client.get(urlString = url) {
            parameters.forEach { (key, value) ->
                parameter(key = key, value = value)
            }
        }
    }

    suspend inline fun <reified T : Any> post(url: String, body: Any): T = call {
        postRequest(url = url, body = body)
    }

    suspend inline fun <reified T : Any> get(url: String, parameters: Map<String, Any> = emptyMap()): T = call {
        getRequest(url = url, parameters = parameters)
    }

    fun handleError(response: HttpResponse) {
        when (response.status) {
            HttpStatusCode.BadRequest -> throw BadRequest()
            HttpStatusCode.Unauthorized -> throw Unauthorized()
            HttpStatusCode.InternalServerError -> throw InternalServerError()
            else -> throw UnknownNetworkException()
        }
    }
}
