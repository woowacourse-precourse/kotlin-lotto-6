package lotto.domain

open class RetryUntilSuccess {

    protected fun <T> doUntilSuccess(function: () -> T): T {
        while (true) {
            try {
                return function()
            } catch (e: IllegalArgumentException) {
                val errorMessage = e.message ?: throw IllegalArgumentException(ERROR_SHOULD_CONTAIN_MESSAGE)
                println(errorMessage)
            }
        }
    }

    companion object {
        private const val ERROR_SHOULD_CONTAIN_MESSAGE = "에러가 발생하면 메시지를 반드시 포함해야 합니다."
    }
}