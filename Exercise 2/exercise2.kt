
fun describeStatus(code: Int): String {
    when(code) {
        in 200..299 -> return "Success: The request was fulfilled."
        in 400..499 -> return "Client Error: Check your URL or parameters."
        in 500..599 -> return "Server Error: The Lehman Server is having trouble."
        else -> return "Unknown status code."
    }


}




fun main(){

    println(describeStatus(201))
    println(describeStatus(404))
    println(describeStatus(503))

}