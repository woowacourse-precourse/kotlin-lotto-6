package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class InputView {
    fun inputPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        return try {
            validatePurchaseAmount(purchaseAmount)
        } catch (exception : IllegalArgumentException) {
            println(exception.message)
            println(INPUT_RETRY_MENTION)
            inputPurchaseAmount()
        }
    }

    fun validatePurchaseAmount(purchaseAmount: String) : Int {
        try {
            require(purchaseAmount.isNotEmpty()) { ERROR_INPUT_PRICE_MENTION }
            val validPurchaseAmount = purchaseAmount.toInt()
            require(validPurchaseAmount >= MINIMUM_PRICE) { ERROR_LESS_THAN_THOUSAND_MENTION }
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException( ERROR_UNDEFINED_PRICE_MENTION )
        }
        return purchaseAmount.toInt()
    }

    fun inputWinningNumberList() : List<Int> {
        val winningNumberInput = Console.readLine()
        return try {
            validateInputWinningNumber(winningNumberInput)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            println(INPUT_RETRY_MENTION)
            inputWinningNumberList()
        }
    }

    fun validateInputWinningNumber(winningNumberInput: String): List<Int> {
        try {
            require(!winningNumberInput.contains(SPACE)) { ERROR_CONTAINS_SPACE_MENTION }
            val winningNumberList = winningNumberInput.split(COMMA).map { it.toInt() }
            require(winningNumberList.size == LOTTO_NUMBER_SIZE) { ERROR_NEED_SIX_NUMBERS_MENTION }
            require(winningNumberList.distinct().size == LOTTO_NUMBER_SIZE) { ERROR_REDUNDANT_NUMBER_MENTION }
            require(winningNumberList.all { it in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER }) { ERROR_NUMBER_OUT_OF_BOUND_MENTION }
        } catch (exception: NumberFormatException) {
            //null case 포함됨
            throw IllegalArgumentException(ERROR_UNDEFINED_NUMBER_MENTION)
        }
        return winningNumberInput.split(COMMA).map { it.toInt() }
    }

    fun inputBonusNumber(winningNumberList: List<Int>) : Int {
        val bonusNumberInput = Console.readLine()
        return try {
            validateBonusNumber(winningNumberList, bonusNumberInput)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            println(INPUT_RETRY_MENTION)
            inputBonusNumber(winningNumberList)
        }
    }

    fun validateBonusNumber(winningNumberList: List<Int>, bonusInput: String) : Int {
        try {
            val bonusNumber = bonusInput.toInt()
            require(bonusNumber in LOTTO_MINIMUM_NUMBER .. LOTTO_MAXIMUM_NUMBER) { ERROR_NUMBER_OUT_OF_BOUND_MENTION }
            require(!winningNumberList.contains(bonusNumber)) { ERROR_BONUS_NUMBER_REDUNDANT_MENTION }
        } catch (exception: NumberFormatException){
            //null case 포함
            throw IllegalArgumentException(ERROR_UNDEFINED_NUMBER_MENTION)
        }
        return bonusInput.toInt()
    }

    companion object {
        const val SPACE = " "
        const val COMMA = ","
        const val MINIMUM_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_MINIMUM_NUMBER = 1
        const val LOTTO_MAXIMUM_NUMBER = 45

        const val INPUT_RETRY_MENTION = "다시 입력해주세요"
        const val ERROR_INPUT_PRICE_MENTION = "[ERROR] 금액을 입력해주세요."
        const val ERROR_LESS_THAN_THOUSAND_MENTION = "[ERROR] 1,000원 이상이어야 구매가 가능합니다. (로또 1장 : 1,000원)"
        const val ERROR_UNDEFINED_PRICE_MENTION = "[ERROR] 금액은 숫자만 입력해주셔야하며, Int범위 이내여야합니다. (21억 이하 가능)"
        const val ERROR_CONTAINS_SPACE_MENTION = "[ERROR] 공백없이 입력해주세요."
        const val ERROR_NEED_SIX_NUMBERS_MENTION = "[ERROR] 6개의 숫자를 입력하셔야 합니다."
        const val ERROR_REDUNDANT_NUMBER_MENTION = "[ERROR] 중복되지 않는 6개의 숫자를 입력하셔야 합니다."
        const val ERROR_NUMBER_OUT_OF_BOUND_MENTION = "[ERROR] 1~45 사이의 숫자를 입력하셔야 합니다."
        const val ERROR_UNDEFINED_NUMBER_MENTION = "[ERROR] 숫자를 입력하셔야 합니다."
        const val ERROR_BONUS_NUMBER_REDUNDANT_MENTION = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다."
    }

}