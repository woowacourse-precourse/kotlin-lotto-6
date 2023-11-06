package lotto

import ui.Input
import exception.Exception
import ui.Output

class UserLotto {
    init {
        Output.printInputWinningNumber()
    }

    fun createUserLotto(): Lotto {
        val userLotto = Input.getInputWinningNumber()
        return Lotto(userLotto.sorted())
    }

    fun checkValidUserLotto(userLotto: MutableList<Int>) {
        if (userLotto.size != 6) {
            println(Exception.EXCEPTION_INVALID_SIZE)
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_SIZE)
        }
        if (userLotto.any { it !in 1..45 }) {
            println(Exception.EXCEPTION_INVALID_NUMBER)
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_NUMBER)
        }
        if (userLotto.distinct().size != 6) {
            println(Exception.EXCEPTION_DUPLICATE_NUMBER)
            throw IllegalArgumentException(Exception.EXCEPTION_DUPLICATE_NUMBER)
        }
    }
}