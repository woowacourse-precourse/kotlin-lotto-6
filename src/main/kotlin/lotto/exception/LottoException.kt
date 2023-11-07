package lotto.exception

class LottoException(
        override val message: String,
        private val throwable: Throwable? = null
): IllegalArgumentException(ERROR_PREFIX + message, throwable) {
    companion object {
        const val ERROR_PREFIX = "[ERROR]"
    }
}