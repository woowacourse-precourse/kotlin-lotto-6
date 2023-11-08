package lotto.views

import lotto.constants.Constant.Companion.START_INDEX
import lotto.constants.Message.Companion.MESSAGE_COUNT_UNIT
import lotto.constants.Message.Companion.MESSAGE_INPUT_BONUS_NUMBER
import lotto.constants.Message.Companion.MESSAGE_INPUT_MONEY
import lotto.constants.Message.Companion.MESSAGE_INPUT_WINNING_NUMBERS
import lotto.constants.Message.Companion.MESSAGE_PRINT_AMOUNT
import lotto.constants.Message.Companion.MESSAGE_PRINT_COUNT_FIFTH
import lotto.constants.Message.Companion.MESSAGE_PRINT_COUNT_FIRST
import lotto.constants.Message.Companion.MESSAGE_PRINT_COUNT_FOURTH
import lotto.constants.Message.Companion.MESSAGE_PRINT_COUNT_SECOND
import lotto.constants.Message.Companion.MESSAGE_PRINT_COUNT_THIRD
import lotto.constants.Message.Companion.MESSAGE_PRINT_REWARD
import lotto.constants.Message.Companion.MESSAGE_PRINT_YIELD
import lotto.constants.Message.Companion.MESSAGE_PRINT_YIELD_END
import lotto.domain.LottoWrapper

object OutputView {
    fun printExceptionMessage(message: String) {
        println(message)
    }

    fun printInputMoney() {
        println(MESSAGE_INPUT_MONEY)
    }

    fun printAmount(amount: Int) {
        println("$amount" + MESSAGE_PRINT_AMOUNT)
    }

    fun printLottos(lottos: LottoWrapper) {
        for (index in START_INDEX until lottos.size()) {
            val lotto = lottos.get(index)
            println(lotto.getNumbers())
        }
    }

    fun printInputWinningNumbers() {
        println(MESSAGE_INPUT_WINNING_NUMBERS)
    }

    fun printInputBonusNumber() {
        println(MESSAGE_INPUT_BONUS_NUMBER)
    }

    fun printCountReward(count: MutableList<Int>) {
        println(MESSAGE_PRINT_REWARD)
        println(MESSAGE_PRINT_COUNT_FIFTH + count[4] + MESSAGE_COUNT_UNIT)
        println(MESSAGE_PRINT_COUNT_FOURTH + count[3] + MESSAGE_COUNT_UNIT)
        println(MESSAGE_PRINT_COUNT_THIRD + count[2] + MESSAGE_COUNT_UNIT)
        println(MESSAGE_PRINT_COUNT_SECOND + count[1] + MESSAGE_COUNT_UNIT)
        println(MESSAGE_PRINT_COUNT_FIRST + count[0] + MESSAGE_COUNT_UNIT)
    }

    fun printYield(result: Double) {
        println(MESSAGE_PRINT_YIELD + "$result" + MESSAGE_PRINT_YIELD_END)
    }
}