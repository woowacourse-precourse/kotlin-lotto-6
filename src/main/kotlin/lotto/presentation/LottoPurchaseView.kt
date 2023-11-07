package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoCount
import lotto.domain.LottoMake
import lotto.util.PURCHASE_NUMBER_TEXT
import lotto.util.PURCHASE_PRICE_TEXT

object LottoPurchaseView {
    fun printLottoPurchase() {
        println(PURCHASE_PRICE_TEXT)
    }

    fun inputLottoPurchase() {
        // 로또 구매 금액 입력 구현
        val amount = Console.readLine().trim().toInt()
        outputPurchaseCount(amount)
    }

    private fun outputPurchaseCount(amount: Int) {
        // 몇개를 구매한 것인지 표시해야함
        val count = LottoCount(amount).calculate()
        println()
        println("$count$PURCHASE_NUMBER_TEXT")
        outputLottoNumber(count)
    }

    private fun outputLottoNumber(purchaseCount: Int) {
        // 구매한 개수 만큼의 로또 번호 출력 구현
//        for (count in 0..purchaseCount) {
//            LottoMake.make()
//        }
        LottoMake(purchaseCount).make()
    }
}