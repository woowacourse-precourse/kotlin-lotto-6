package lotto

import lotto.view.Msg
import lotto.view.WinningPrice

class PrintResult(var winningPrice: List<WinningPrice>, val price: Int) {

    val standard: List<WinningPrice> = listOf(WinningPrice.NONE, WinningPrice.THREE, WinningPrice.FOUR, WinningPrice.FIVE, WinningPrice.FIVE_AND_BONUS, WinningPrice.SIX)
    val result = mutableListOf<Int>()

    init {
        calculate()
    }

    private fun calculate() {
        for (i in standard) {
            result.add(count(i))
        }

        show()

    }

    private fun show() {
        println(Msg.OUTPUT_WINNING_STATUS.msg)
        println(Msg.OUTPUT_THREE_CORRECT.msg + result[1] + "개")
        println(Msg.OUTPUT_FOUR_CORRECT.msg + result[2] + "개")
        println(Msg.OUTPUT_FIVE_CORRECT.msg + result[3] + "개")
        println(Msg.OUTPUT_FIVE_BOUNUS_CORRECT.msg + result[4] + "개")
        println(Msg.OUTPUT_SIX_CORRECT.msg + result[5] + "개")
        calculateRate()

    }

    private fun calculateRate() {
        var totalPrice = 0
        for (i in 0 until standard.size) {
            totalPrice += standard[i].value * result[i]
        }
        println(Msg.OUTPUT_RATE_RETURN.msg + totalPrice / price * 100 + "%입니다.")
    }

    fun count(price: WinningPrice): Int {
        return winningPrice.count() {
            it.equals(price)
        }
    }
}