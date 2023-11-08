package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.CashierState.*

class Cashier {

    private val machine = LottoMachine()

    fun purchase(): List<Lotto> {
        println(GREETING_MESSAGE)
        val price = getPriceSafely()
        return machine.buy(price / UNDER_BOUND_PRICE)
    }

    private fun getPriceSafely(): Int =
        try {
            getPrice()
        } catch (iae: IllegalArgumentException) {
            printError(iae.message ?: "")
            getPriceSafely()
//        } catch (ise: IllegalStateException) {
//            printError(SYSTEM_ERROR)
//            getPriceSafely()
//        } catch (nse: NoSuchElementException) {
//            printError(SYSTEM_ERROR)
//            getPriceSafely()
        }

    private fun getPrice(): Int {
        val input = Console.readLine()
        return when (val state = checkInput(input)) {
            NOT_INT,
            INCORRECT_FORMAT -> {
                throw IllegalArgumentException(state.message)
            }

            VALID -> input.toInt()
        }
    }

    private fun checkInput(input: String): CashierState {
        if (isNotInteger(input)) {
            return NOT_INT
        }

        if (isIncorrectFormat(input)) {
            return INCORRECT_FORMAT
        }

        return VALID
    }

    private fun isNotInteger(input: String): Boolean =
        try {
            input.toInt()
            false
        } catch (nfe: NumberFormatException) {
            true
        }

    private fun isIncorrectFormat(input: String): Boolean = input.toInt() % UNDER_BOUND_PRICE != 0

    private fun printError(message: String) = println("$PREFIX_ERROR $message")

    companion object {
        private const val GREETING_MESSAGE = "구입금액을 입력해 주세요."
        private const val PREFIX_ERROR = "[ERROR]"
        private const val UNDER_BOUND_PRICE = 1000
        private const val SYSTEM_ERROR = "시스템 오류입니다."
    }
}

enum class CashierState(val message: String) {
    VALID("유효함"), NOT_INT("숫자만 입력해주세요."), INCORRECT_FORMAT("1,000원 단위로 구매가능합니다.")
}