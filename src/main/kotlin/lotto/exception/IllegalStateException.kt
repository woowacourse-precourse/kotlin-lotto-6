package lotto.exception

import lotto.constants.ErrorConstants
import kotlin.IllegalStateException

class IllegalStateException(
    private val errorMessage: String
) : IllegalStateException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val stateNotInitialized = IllegalStateException(
            errorMessage = ErrorConstants.NOT_INITIALIZED
        )
    }
}