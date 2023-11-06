package lotto

fun validateAndThrowExceptionIfError(tryLogic: () -> Unit) {
    while (true) {
        try {
            tryLogic()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}