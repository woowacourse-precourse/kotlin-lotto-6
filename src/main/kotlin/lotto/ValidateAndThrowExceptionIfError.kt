package lotto

fun doLogic(tryLogic: () -> Unit) {
    while (true) {
        try {
            tryLogic()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}