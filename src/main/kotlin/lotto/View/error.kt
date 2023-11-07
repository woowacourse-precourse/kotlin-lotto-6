package lotto.View

object Error {
    fun notValidPurchaseAmount() {
        println(ErrorText.NOT_VALID_PURCHASE_AMOUNT)
    }

    fun NAN() {
        println(ErrorText.NAN)
    }

    fun duplicateWinningNumber() {
        println(ErrorText.DUPLICATE_WINNING_NUMBER)
    }

    fun notValidWinningNumber() {
        println(ErrorText.NOT_VALID_WINNING_NUMBER)
    }

    fun notValidBonusNumber() {
        println(ErrorText.NOT_VALID_BONUS_NUMBER)
    }

    fun notValidWinningNumberLength() {
        println(ErrorText.NOT_VALID_WINNING_NUMBER_LENGTH)
    }
}
