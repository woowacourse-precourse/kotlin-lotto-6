package lotto.view

import lotto.constants.Strings
import lotto.model.Lottos
import lotto.model.Rank
import lotto.model.WinningResult
import java.text.DecimalFormat

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

    fun outputWinningResult(winningResult: WinningResult) {
        outputBlankLine()
        println("""
            ${Strings.WINNING_STATICS}
            ---            
        """.trimIndent())
        for (prize in Rank.values()) {
            if(prize == Rank.NONE) continue
            if(prize == Rank.SECOND) {
                println(Strings.WINNING_RESULT_MATCH_BONUS.format(prize.matchCnt, dec(prize.winningMoney), winningResult[prize]))
                continue
            }
            println(Strings.WINNING_RESULT_BASIC.format(prize.matchCnt, dec(prize.winningMoney), winningResult[prize]))
        }
    }

    private fun dec(num: Int) : String {
        val dec = DecimalFormat("#,###")
        return dec.format(num)// 123,456
    }

    private fun outputBlankLine() {
        println()
    }
}