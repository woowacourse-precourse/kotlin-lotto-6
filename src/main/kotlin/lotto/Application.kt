package lotto

fun main() {
    val purchase = PurchaseAmount()
    val purchaseAmount = purchase.enterNumber()  // 구입횟수

    val lottos = Lottos()
    val numbers = lottos.getNumbers(purchaseAmount)
    lottos.printLottos(numbers)  // 오름차순 후 출력

    val winningNumber = WinningNumber()
    winningNumber.inputWinningNumber()
    winningNumber.inputBonusNumber()
}
