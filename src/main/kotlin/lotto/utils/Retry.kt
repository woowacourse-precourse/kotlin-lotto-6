package lotto.utils

fun retryWhileNoException(action: () -> Any): Any {
    while (true) {
        try {
            return action.invoke()
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }
}