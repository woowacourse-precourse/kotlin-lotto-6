package lotto.view

import lotto.domain.LottoBundle

object OutputView {
    fun printLottosNumbers(lottobundle: LottoBundle) {
        println("${lottobundle.amount()}개를 구매했습니다.")
        lottobundle.forEach { lotto ->
            println(lotto.toString())
        }
        println()
    }
}