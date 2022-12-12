package aleksandr.fedotkin.sellercryptomoney.data.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.coroutines.runBlocking

class Websockets(private val client: HttpClient) {

    suspend fun check() = runBlocking {
        client.webSocket(method = HttpMethod.Get, host = "10.0.2.2", port = 8080, path = "/check") {
            while(true) {
                send(content = "dwadwadwa")
                val othersMessage = incoming.receive() as? Frame.Text
                println(othersMessage?.readText())
                val myMessage = "dwadwadwadwadwadwadwa"
                if(myMessage != null) {
                    send(content = myMessage)
                }
            }
        }
    }
}
