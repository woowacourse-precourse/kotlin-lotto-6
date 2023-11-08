package lotto.validation

class ExceptionMessageManager {

    fun printErrorMessage(errorMessage: String?) =
        println("$ERROR_START_MESSAGE $errorMessage")

    companion object {
        const val ERROR_START_MESSAGE = "[ERROR]"
    }
}