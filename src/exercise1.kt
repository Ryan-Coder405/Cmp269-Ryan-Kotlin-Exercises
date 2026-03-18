fun main() {

    var studentName: String
    var middleName: String?

    studentName = "Ryan"
    middleName = null ?: "No Middle Name"

    println("Welcome, [$studentName] [$middleName]!")

}