package lotto.io

import lotto.Lotto

class Output {
    fun printAmountMsg() {
        println("구입금액을 입력해 주세요.")
    }

    fun printQuantityMsg(quantity: Int) {
        printBlankLine()
        println("${quantity}개를 구매했습니다.")
    }

    fun printWinningNumbersMsg() {
        printBlankLine()
        println("당첨 번호를 입력해 주세요.")
    }

    private fun printBlankLine() {
        println()
    }

    fun printBonusNumberMsg() {
        printBlankLine()
        println("보너스 번호를 입력해 주세요.")
    }

    fun printLotto(lottoTickets: List<Int>){
        println(lottoTickets)
    }
}