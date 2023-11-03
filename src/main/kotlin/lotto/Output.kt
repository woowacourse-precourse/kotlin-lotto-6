package lotto

import lotto.constant.OutputMessage
import lotto.domain.LottoSet
import lotto.domain.Winning
import lotto.constant.OutputMessage.Companion.MESSAGE_PER_COUNT

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
        println(OutputMessage.MESSAGE_WINNING_RATE_FIFTH + winningRateCount[4].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_FOURTH + winningRateCount[3].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_THIRD + winningRateCount[2].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_SECOND + winningRateCount[1].toString() + MESSAGE_PER_COUNT)
        println(OutputMessage.MESSAGE_WINNING_RATE_FIRST + winningRateCount[0].toString() + MESSAGE_PER_COUNT)
    }

    fun printEarningRate(earningRate: Double) {
        println(OutputMessage.MESSAGE_EARNING_RATE_PREFIX + earningRate.toString() + OutputMessage.MESSAGE_EARNING_RATE_POSTFIX)
    }
}