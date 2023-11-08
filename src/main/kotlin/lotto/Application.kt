package lotto

fun main() {
    val inputManager = InputManager(ExceptionManager())
    val printManager = PrintManager()
    val gameManager = GameManager(printManager)

    printManager.inputMoney()
    val money = inputManager.money()

    val lottos = gameManager.makeLottosByMoney(money)

    printManager.inputWinningNumber()
    val winningNumber = inputManager.winningNum()

    printManager.inputBonusNumber()
    val bonusNumber = inputManager.bonusNum(winningNumber)

    gameManager.playGame(lottos, winningNumber, bonusNumber, money)
}
