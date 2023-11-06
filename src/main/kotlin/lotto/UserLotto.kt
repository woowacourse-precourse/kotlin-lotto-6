package lotto

import ui.Input
import exception.Exception
import ui.Output

class UserLotto {
    init {
        Output.printInputWinningNumber()
    }

    fun createUserLotto(): Lotto {
try {
            val userLotto = Input.getInputWinningNumber()
            checkValidUserLotto(userLotto)
            return Lotto(userLotto)
        } catch (e: InvalidUserLottoException) {
            println(e.message)
            return createUserLotto()
        } catch (e: NumberFormatException) {
            println(Exception.EXCEPTION_INVALID_NUMBER)
            return createUserLotto()
        }
    }


}
class InvalidUserLottoException(message: String) : IllegalArgumentException(message)

fun checkValidUserLotto(userLotto: MutableList<Int>) {
    if (userLotto.size != 6) {
        throw InvalidUserLottoException(Exception.EXCEPTION_INVALID_SIZE)
    }
    if (userLotto.any { it !in 1..45 }) {
        throw InvalidUserLottoException(Exception.EXCEPTION_INVALID_NUMBER)
    }
    if (userLotto.distinct().size != 6) {
        throw InvalidUserLottoException(Exception.EXCEPTION_DUPLICATE_NUMBER)
    }
}
