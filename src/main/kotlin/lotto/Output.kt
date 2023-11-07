package lotto

import lotto.constant.OutputMessage
import lotto.domain.LottoSet
import lotto.domain.Winning
import lotto.constant.OutputMessage.Companion.MESSAGE_PER_COUNT
import lotto.constant.Constant.Companion.WINNING_RATE_FIRST_INDEX
import lotto.constant.Constant.Companion.WINNING_RATE_SECOND_INDEX
import lotto.constant.Constant.Companion.WINNING_RATE_THIRD_INDEX
import lotto.constant.Constant.Companion.WINNING_RATE_FOURTH_INDEX
import lotto.constant.Constant.Companion.WINNING_RATE_FIFTH_INDEX

object Output {
    fun printLottoCount(lottoCount: Int) {
        println(OutputMessage.CHANGE_LINE + lottoCount.toString() + OutputMessage.MESSAGE_PRINT_LOTTO_COUNT)
    }

    fun printLottoNumber() {

        val lottoSetList = LottoSet.getLottoSet()

        for(i in lottoSetList.indices) {
            println(lottoSetList[i].getNumberPerLotto().joinToString(separator=", ",prefix="[",postfix="]"))
        }
    }

    fun printWinningRate() {
        val winningRateCount = Winning.getWinningRateCount()
        println(OutputMessage.MESSAGE_WINNING_RATE_START)
        println(OutputMessage.MESSAGE_WINNING_RATE_FIFTH + winningRateCount[WINNING_RATE_FIFTH_INDEX].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_FOURTH + winningRateCount[WINNING_RATE_FOURTH_INDEX].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_THIRD + winningRateCount[WINNING_RATE_THIRD_INDEX].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_SECOND + winningRateCount[WINNING_RATE_SECOND_INDEX].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_FIRST + winningRateCount[WINNING_RATE_FIRST_INDEX].toString() + MESSAGE_PER_COUNT)
    }

    fun printEarningRate(earningRate: String) {
        println(OutputMessage.MESSAGE_EARNING_RATE_PREFIX + earningRate + OutputMessage.MESSAGE_EARNING_RATE_POSTFIX)
    }
}