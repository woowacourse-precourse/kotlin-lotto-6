package lotto.util

import lotto.constants.ErrorMessage

class HandleException {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun <T> tryUntilSuccess(fn: () -> T ) : T {
        return runCatching(fn).onSuccess {
            return it
        }.getOrElse {
            printError(it.message + " ${errorMessage.INPUT_AGAIN}\n")
            return tryUntilSuccess(fn)
        }
    }

    fun printError(e: String?) {
        println("${errorMessage.ERROR_PREFIX} ${e ?: errorMessage.UNKNOWN_ERROR}")
    }
}