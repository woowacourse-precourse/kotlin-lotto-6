package lotto.view

import lotto.Lotto

class OutputView {
    fun amountMessage() {
        println("구입 금액을 입력해 주세요.")
    }

    fun winningMessage() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun bonusMessage() {
        println("보너스 번호를 입력해 주세요.")
    }

    private fun printEnd() {
        println("당첨 통계")
    }

    private fun printHorizon() {
        println("---")
    }

    private fun printEmptyLine() {
        println()
    }

    private fun printNumberOfGame(game: Int) {
        println("%d개를 구매했습니다.".format(game))
    }
    private fun printPurchaseAGame(number: List<Int>) {
        println(number)
    }
    fun printPurchase(game: Int, lottos: List<Lotto>) {
        printNumberOfGame(game)
        for (lotto in lottos) {
            printPurchaseAGame(lotto.getLotto())
        }
        printEmptyLine()
    }

    private fun printRank(ranks: List<Int>) {
        println("3개 일치 (5,000원) - %d개".format(ranks[0]))
        println("4개 일치 (50,000원) - %d개".format(ranks[1]))
        println("5개 일치 (1,500,000원) - %d개".format(ranks[2]))
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개".format(ranks[3]))
        println("6개 일치 (2,000,000,000원) - %d개".format(ranks[4]))
    }
    private fun printBenefit(rate: Float) {
        println("총 수익률은 %.1f%%입니다.".format(rate*100))
    }
    fun printGameResult(ranks: List<Int>, rate: Float) {
        printEnd()
        printHorizon()
        printRank(ranks)
        printBenefit(rate)
    }
}