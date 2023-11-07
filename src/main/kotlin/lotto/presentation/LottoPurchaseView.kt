package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.util.PURCHASE_NUMBER_TEXT
import lotto.util.PURCHASE_PRICE_TEXT

object LottoPurchaseView {
    fun printLottoPurchase() {
        println(PURCHASE_PRICE_TEXT)
    }

    fun inputLottoPurchase() {
        // 로또 구매 금액 입력 구현
        val amount = Console.readLine().trim()
    }

    fun outputPurchaseCount() {
        // 몇개를 구매한 것인지 표시해야함
        println(PURCHASE_NUMBER_TEXT)
    }

    fun outputLottoNumber() {
        // 구매한 개수 만큼의 로또 번호 출력 구현
        println()
    }
}