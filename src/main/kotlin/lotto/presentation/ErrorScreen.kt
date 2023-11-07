package lotto.presentation

class ErrorScreen {
    fun outputErrorMessage(e: IllegalArgumentException) =
        println("$ERROR_MESSAGE_SETTING${e.message}$LINE_SEPARATOR")

    companion object {
        const val ERROR_MESSAGE_SETTING = "[ERROR] "
        const val LINE_SEPARATOR = "\n"
    }
}