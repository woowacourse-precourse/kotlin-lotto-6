package lotto.error

interface ErrorHandler {
    fun handle(action: () -> Unit, callback: () -> Unit)
}