package lotto.view

import lotto.enums.OutPut

class LottoView {
    fun printEnterPurchaseMessage() {
        println(OutPut.PLEASE_INPUT_AMOUNT.message)
    }

    fun printEnterWinningNumberMessage() {
        println(OutPut.PLEASE_INPUT_WINNING_NUMBER.message)
    }

    fun printEnterBonusNumberMessage() {
        println(OutPut.PLEASE_INPUT_BOUNS_NUMBER.message)
    }

    fun displayLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("\n${lottoNumbers.size} ${OutPut.PURCHASED.message}")
        lottoNumbers.forEach { numbers ->
            println(numbers.sorted())
        }
    }
}