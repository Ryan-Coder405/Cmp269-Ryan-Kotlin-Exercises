data class Laptop(val brand: String, val ramGB: Int)
fun Int.toLehmanGigabytes(): String = "$this GB (Lehman Standard)"

fun main() {

    val lappy = Laptop("lenuvo", 16)
    val macbook = Laptop("Apple", 32)



    //Macbook
    println("This laptop from ${macbook.brand} has this much RAM: ${macbook.ramGB.toLehmanGigabytes()}")
    //Lenuvo
    println("This laptop from ${lappy.brand} has this much RAM: ${lappy.ramGB.toLehmanGigabytes()}")

}