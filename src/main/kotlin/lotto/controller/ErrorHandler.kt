package lotto.controller

object ErrorHandler {
    fun <T> repeatInputIncorrect(function: () -> T): T {
        while (true) {
            try {
                return function()
            } catch (e: IllegalStateException) {
                println(e.message)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}