package lotto.validation

import lotto.domain.ErrorType
import lotto.domain.MessageManager

class ExceptionMessageManager {

    fun printErrorMessage(errorMessage: String?) =
        println("$ERROR_START_MESSAGE $errorMessage")

    companion object {
        const val ERROR_START_MESSAGE = "[ERROR]"
    }
}