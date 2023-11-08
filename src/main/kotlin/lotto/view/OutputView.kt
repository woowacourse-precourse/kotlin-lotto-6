package lotto.view

import lotto.constants.Strings
import lotto.model.Lottos

class OutputView {
    private val strings: Strings = Strings

    fun outputAmount() {
        println(strings.OUTPUT_PURCHASE_AMOUNT)
    }

    fun outputLottos(lottoCnt: Int, userLottos: Lottos) {
        outputBlankLine()
        outputLottoCnt(lottoCnt)
        outputUserLottos(userLottos)
    }

    private fun outputLottoCnt(cnt: Int) {
        println(strings.OUTPUT_LOTTO_COUNT.format(cnt))
    }

    private fun outputUserLottos(userLottos: Lottos) {
        userLottos.lottos.forEach{
            println(it.getNumbers())
        }
    }

    fun outputWinningNums() {
        outputBlankLine()
        println(Strings.OUTPUT_WINNING_NUMS)
    }

    fun outputBonusNum() {
        outputBlankLine()
        println(Strings.OUTPUT_BONUS_NUM)
    }

    private fun outputBlankLine() {
        println()
    }
}