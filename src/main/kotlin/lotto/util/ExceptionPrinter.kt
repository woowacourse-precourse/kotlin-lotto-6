package lotto.util

object ExceptionPrinter {

    fun <T> tryCatchAndPrintException(block: () -> T) {
        try {
            block()
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }
}
