package lotto.view

object OutputView {
    fun printStartMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseTotal(total: Int) {
        println("\n${total/1000}개를 구매했습니다.")
    }

    fun printWinningMessage() {
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun printBonusMessage() {
        println("\n보너스 번호를 입력해 주세요.")
    }

    fun printWinningReport() {
        println("당첨 통계\n---")
    }
}