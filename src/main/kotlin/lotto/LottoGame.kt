package lotto

class LottoGame(private val user: User) {

    fun start() {
        showMessage(INPUT_AMOUNT_MESSAGE)
        val amount = inputAmountFromUser()
        println(amount)

        showMessage(INPUT_WINNING_NUMBERS)
        val winningNumbers = inputWinningNumbersFromUser()
        println(winningNumbers)

        showMessage(INPUT_BONUS_NUMBER)
        val bonusNumber = inputBonusNumberFromUser()
        println(bonusNumber)
    }

    private fun inputAmountFromUser(): Int {
        while (user.amount == 0) {
            try {
                user.inputAmount()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.amount
    }

    private fun inputWinningNumbersFromUser(): List<Int> {
        while (user.winningNumbers.isEmpty()) {
            try {
                user.inputWinningNumbers()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.winningNumbers
    }

    private fun inputBonusNumberFromUser(): Int {
        while (user.bonusNumber == 0) {
            try {
                user.inputBonusNumber()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.bonusNumber
    }

    private fun showMessage(message: String) = println(message)

    private fun showErrorMessage(errorMessage: String) = println("$PREFIX_ERROR_MESSAGE $errorMessage")

    companion object {
        const val PREFIX_ERROR_MESSAGE = "[ERROR]"
        const val UNKNOWN_ERROR_MESSAGE = "알 수 없는 에러가 발생했습니다."

        const val INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    }
}