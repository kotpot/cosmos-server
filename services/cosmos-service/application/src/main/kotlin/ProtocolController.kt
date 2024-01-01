package org.kotpot.cosmos

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import okio.ByteString
import org.kotpot.cosmos.ktor.server.plugins.KtorRouter
import org.kotpot.cosmos.pb.common.ProtocolServiceCall
import org.kotpot.cosmos.pb.test.rpc.KrpcTestService
import org.springframework.stereotype.Controller

@Controller
class ProtocolController(
    val testService: KrpcTestService
): KtorRouter {

    context(Route) override fun register() {
        post("/protocol/call") {
            val body = call.receive<ByteArray>()
            val response = dispatchServiceFunction(body)
            call.respondBytes(response, ContentType.Application.ProtoBuf)
        }
    }

    private suspend fun dispatchServiceFunction(body: ByteArray): ByteArray {
        val call = ProtocolServiceCall.ADAPTER.decode(body)
        val service = when(call.service_name) {
            testService.serverName -> testService
            else -> throw IllegalStateException("Illegal service name ${call.service_name}")
        }
        val bytes = call.placeholder.toByteArray()
        return service.call(bytes, call.call_function)
    }

}