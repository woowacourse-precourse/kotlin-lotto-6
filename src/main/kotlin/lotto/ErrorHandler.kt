package lotto

import java.lang.NumberFormatException

class ErrorHandler {
    fun checkWithExceptionHandler(condition: () -> Boolean, errorMessage: String, errorType: ErrorType): Boolean {
        if (!condition()) {
            when (errorType) {
                ErrorType.NumberFormatException -> surroundTryCatchWithNumberFormatException(errorMessage, errorType)
                ErrorType.IllegalArgumentException -> surroundTryCatchWithIllegalArgumentException(errorMessage, errorType)
                ErrorType.IllegalStateException -> surroundTryCatchWithIllegalStateException(errorMessage, errorType)
                else -> surroundTryCatchWithException(EXCEPTION_MESSAGE, errorType)
            }
            return false
        }
        return true
    }

    private fun surroundTryCatchWithIllegalArgumentException(errorMessage: String, errorType: ErrorType) {
        try {
            ErrorType.throwException(errorMessage, errorType)
        } catch (e: IllegalArgumentException) {
            ErrorPrinter.printError(errorMessage)
        }
    }

    private fun surroundTryCatchWithIllegalStateException(errorMessage: String, errorType: ErrorType) {
        try {
            ErrorType.throwException(errorMessage, errorType)
        } catch (e: IllegalStateException) {
            ErrorPrinter.printError(errorMessage)
        }
    }

    private fun surroundTryCatchWithNumberFormatException(errorMessage: String, errorType: ErrorType) {
        try {
            ErrorType.throwException(errorMessage, errorType)
        } catch (e: NumberFormatException) {
            ErrorPrinter.printError(errorMessage)
        }
    }

    private fun surroundTryCatchWithException(errorMessage: String, errorType: ErrorType) {
        try {
            ErrorType.throwException(errorMessage, errorType)
        } catch (e: Exception) {
            ErrorPrinter.printError(errorMessage)
        }
    }

    companion object {
        const val EXCEPTION_MESSAGE = "예기치 못한 오류입니다."
    }
}

