package lotto.util

fun retryUntilSuccess(tryLogic: () -> Unit) {
    while (true) {
        try {
            tryLogic()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}