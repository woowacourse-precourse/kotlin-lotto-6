package lotto

import ui.Input
import exception.Exception

class UserLotto {
    init {
        Input.getInputWinningNumber()
    }

    fun createUserLotto(): Lotto {
        val userLotto = Input.getInputWinningNumber()
        return Lotto(userLotto.sorted())
    }

    fun checkValidUserLotto(userLotto: MutableList<Int>) {
        if (userLotto.size != 6) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_SIZE)
        }
        if (userLotto.any { it !in 1..45 }) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_NUMBER)
        }
        if (userLotto.distinct().size != 6) {
            throw IllegalArgumentException(Exception.EXCEPTION_DUPLICATE_NUMBER)
        }
    }
}