package lotto

object ErrorPrinter {

    private const val ERROR_HEADER = "[ERROR]"
    fun printError(errorMsg: String) = println("$ERROR_HEADER $errorMsg")

}