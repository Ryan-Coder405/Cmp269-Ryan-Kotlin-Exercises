sealed class EnrollmentStatus{
    data class Success(val courseCode: String) : EnrollmentStatus()
    data class Error(val message: String) : EnrollmentStatus()
    data class Loading(val message: String) : EnrollmentStatus()
}

fun printStatus(status: EnrollmentStatus) {
    when (status) {
        is EnrollmentStatus.Success -> println("Success")
        is EnrollmentStatus.Error -> println("Error")
        is EnrollmentStatus.Loading -> println("Loading")
    }



}


fun main(){

    val good = EnrollmentStatus.Success("791")
    val bad = EnrollmentStatus.Error("Error")

    printStatus(good)
    printStatus(bad)
    printStatus(EnrollmentStatus.Loading("2"))

}