package lotto.domain

open class RetryUntilSuccess {

    protected fun <T> doUntilSuccess(function: () -> T): T {
        while (true) {
            try {
                return function()
            } catch (e: IllegalArgumentException) {
                val errorMessage = e.message ?: "[ERROR] ${e.stackTraceToString()}"
                println(errorMessage)
            }
        }
    }
}