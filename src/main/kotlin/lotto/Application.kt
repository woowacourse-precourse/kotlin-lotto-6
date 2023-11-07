package lotto

fun main() {
    val inputPromptMoney = "구입금액을 입력해 주세요."
    val inputPromptWinningNumbers = "당첨 번호를 입력해 주세요."
    val inputPromptBonusNumber = "보너스 번호를 입력해 주세요."

    val inputManager = InputManager(ExceptionManager())
    val gameManager = GameManager()

    println(inputPromptMoney)
    val money = inputManager.money()

    println(inputPromptWinningNumbers)
    val winningNumbers = inputManager.winningNum()

    println(inputPromptBonusNumber)
    val bonusNumber = inputManager.bonusNum()


}
