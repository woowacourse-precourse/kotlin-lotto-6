package lotto.view

import lotto.enums.OutPut

class LottoView {
    fun printEnterPurchaseMessage() {
        println(OutPut.PLEASE_INPUT_AMOUNT.message)
    }

    fun displayLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("\n${lottoNumbers.size} ${OutPut.PURCHASED.message}")
        lottoNumbers.forEach { numbers ->
            println(numbers.sorted())
        }
    }
}