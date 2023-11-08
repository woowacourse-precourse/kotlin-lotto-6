package lotto.view

class OutputView {
    fun printEnterPurchaseAmount() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseAmount(purchaseAmount: Int) {
        println("\n${purchaseAmount}개를 구매했습니다.")
    }

    fun printPurchasedLotto(purchasedLotto: List<Int>) {
        println(purchasedLotto.sorted())
    }

    fun printEnterPrizeLottoNumber() {
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun printEnterPrizeBonusNumber() {
        println("\n보너스 번호를 입력해 주세요.")
    }

    fun printResultComment() {
        println("\n당첨 통계\n---")
    }

    fun printResult(numberMatch: Int, prize: Int, bonusNumber: Boolean, wonCount: Int) {
        if (bonusNumber == true) {
            println("${numberMatch}개 일치, 보너스 볼 일치 (${String.format("%,d", prize)}원) - ${wonCount}개")
            return
        }
        println("${numberMatch}개 일치 (${String.format("%,d", prize)}원) - ${wonCount}개")
    }

    fun printProfit(profit: Float) {
        println("총 수익률은 ${String.format("%,.1f", profit)}%입니다.")
    }
}