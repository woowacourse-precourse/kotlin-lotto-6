package lotto

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
    fun printEnd() {
        println("당첨 통계")
    }
    fun printHorizon() {
        println("---")
    }
    fun printNumberOfGame(game: Int) {
        println("%d개를 구매했습니다.".format(game))
    }
    fun printPurchaseAGame(number: List<Int>) {
        println(number)
    }
    fun printPurchaseLotto(game: Int, numbers: List<List<Int>>) {
        printNumberOfGame(game)
        for (number in numbers) {
            printPurchaseAGame(number)
        }
    }
}