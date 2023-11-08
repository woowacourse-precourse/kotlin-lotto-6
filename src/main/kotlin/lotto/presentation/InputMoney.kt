package lotto.presentation

import lotto.Lotto
import lotto.exception.NonDivisibleLottoPurchaseAmountException
import lotto.exception.NonNumberLottoPurchaseAmountException
import lotto.exception.NonPositiveLottoPurchaseAmountException

class InputMoney {
    companion object {
        fun validateInputMoney(input: String) {
            validateInputMoneyIsNumber(input)
            validatePurchaseMoney(input.toInt())
        }

        private fun validateInputMoneyIsNumber(inputMoney: String) {
            inputMoney.toIntOrNull() ?: throw NonNumberLottoPurchaseAmountException()
        }

        private fun validatePurchaseMoney(inputMoney: Int) {
            require(inputMoney >= 1000) {
                throw NonPositiveLottoPurchaseAmountException()
            }
            require(inputMoney % Lotto.LOTTO_PRICE_PER_GAME == 0) {
                throw NonDivisibleLottoPurchaseAmountException()
            }
        }
    }
}