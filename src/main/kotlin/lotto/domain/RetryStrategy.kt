package lotto.domain

open class RetryStrategy {

    protected fun <T> doUntilSuccess(operation: () -> T): T {
        while (true) {
            try {
                return operation()
            } catch (e: IllegalArgumentException) {
                val errorMessage = e.message ?: "[ERROR] ${e.stackTraceToString()}"
                println(errorMessage)
            }
        }
    }

    protected fun <T> executeWithFallback(primary: () -> T, fallback: () -> T): T {
        try {
            return primary()
        } catch (e: IllegalArgumentException) {
            val errorMessage = e.message ?: "[ERROR] ${e.stackTraceToString()}"
            println(errorMessage)
        }
        return fallback()
    }
}