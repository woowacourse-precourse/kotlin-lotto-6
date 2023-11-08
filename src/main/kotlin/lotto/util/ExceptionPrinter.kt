package lotto.util

object ExceptionPrinter {

    fun <T> executeSafelyAndPrintException(block: () -> T): Boolean {
        try {
            block()
        } catch (e: IllegalArgumentException) {
            println(e)
            return false
        }
        return true
    }
}
