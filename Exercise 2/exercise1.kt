
data class WebResponse(val statusCode: Int, val statusMessage: String, val body: String?)



fun main(){
    WebResponse(200, "Success","This is a web response")
    WebResponse(404, "Not Found","This is a web response")

    println(WebResponse(200, "Success","This is a web response"))
    println(WebResponse(404, "Not Found","This is a web response"))
}