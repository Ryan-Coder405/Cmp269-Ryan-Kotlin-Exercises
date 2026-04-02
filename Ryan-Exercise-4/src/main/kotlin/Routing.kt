package com.example

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.ByteArrayOutputStream
import java.nio.file.FileSystems

fun saveQRCode(content: String, filename: String): ByteArray? {
    val code = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 512, 512)
    //val path = FileSystems.getDefault().getPath(filename)
    val outputStream = ByteArrayOutputStream()
    MatrixToImageWriter.writeToStream(code, "PNG", outputStream)
    return outputStream.toByteArray()
    //return MatrixToImageWriter.writeToPath(code, "PNG", path)
}

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/qr"){
            val data = call.request.queryParameters["text"] ?: return@get call.respondText("data is missing")
            val bitMatrix = QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, 512, 512)
            val output = saveQRCode(data, "image")

            call.response.header(HttpHeaders.ContentType, "image/png")
            call.respond(output as Any)

        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
