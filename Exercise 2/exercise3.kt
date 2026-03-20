fun routeRequest(path: String, user: String?): String {
    var result = ""



    when(path){
        "/home" -> result = "Welcome to the Lehman Homepage, ${user ?: "Guest"}!"
        //found out about ?.let from a stackoverflow post
        "/grades" -> result = user?.let {"404: Path $path not found." } ?: "Error: Unauthorized access to grades."
        else -> result = "404: Path $path not found."
    }

    return result
}



fun main(){

    println(routeRequest("/home", "bob"))
    println(routeRequest("/grades", null))
    println(routeRequest("/null", null))


}