package lotto

fun errorMessageFormat(errorMessage: String): String {
    return "[ERROR] %s".format(errorMessage)
}

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