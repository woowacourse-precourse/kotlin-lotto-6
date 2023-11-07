package lotto

enum class ErrorType {
    IllegalArgumentException,
    IllegalStateException,
    IndexOutOfBoundsException,
    NumberFormatException,
    NullPointerException,
    Exception;

    companion object {
        fun throwException(errorMessage: String, errorType: ErrorType) {
            when (errorType) {
                IllegalArgumentException -> throw IllegalArgumentException(errorMessage)
                IllegalStateException -> throw IllegalStateException(errorMessage)
                NumberFormatException -> throw NumberFormatException(errorMessage)
                else -> throw Exception()
            }
        }
    }
}