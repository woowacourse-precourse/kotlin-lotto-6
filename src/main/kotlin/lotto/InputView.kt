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
            println("다시 입력해주세요")
            inputPurchaseAmount()
        }
    }

    fun validatePurchaseAmount(purchaseAmount: String) : Int {
        try {
            require(purchaseAmount.isNotEmpty()) { "[ERROR] 금액을 입력해주세요." }
            val validPurchaseAmount = purchaseAmount.toInt()
            require(validPurchaseAmount >= 1000) { "[ERROR] 1,000원 이상이어야 구매가 가능합니다. (로또 1장 : 1,000원)"}
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException( "[ERROR] 금액은 숫자만 입력해주셔야하며, Int범위 이내여야합니다. (21억 이하 가능)" )
        }
        return purchaseAmount.toInt()
    }

    fun inputWinningNumberList() : List<Int> {
        val winningNumberInput = Console.readLine()
        return try {
            validateInputWinningNumber(winningNumberInput)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            println("다시 입력해주세요")
            inputWinningNumberList()
        }
    }

    fun validateInputWinningNumber(winningNumberInput: String): List<Int> {
        try {
            require(!winningNumberInput.contains(" ")) { "[ERROR] 공백없이 입력해주세요." }
            val winningNumberList = winningNumberInput.split(",").map { it.toInt() }
            require(winningNumberList.size == 6) { "[ERROR] 6개의 숫자를 입력하셔야 합니다." }
            require(winningNumberList.distinct().size == 6) { "[ERROR] 중복되지 않는 6개의 숫자를 입력하셔야 합니다." }
            require(winningNumberList.all { it in 1..45 }) { "[ERROR] 1~45 사이의 숫자를 입력하셔야 합니다." }
        } catch (exception: NumberFormatException) {
            //null case 포함됨
            throw IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.")
        }
        return winningNumberInput.split(",").map { it.toInt() }
    }

    fun inputBonusNumber(winningNumberList: List<Int>) : Int {
        val bonusNumberInput = Console.readLine()
        return try {
            validateBonusNumber(winningNumberList, bonusNumberInput)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            println("다시 입력해주세요")
            inputBonusNumber(winningNumberList)
        }
    }

    fun validateBonusNumber(winningNumberList: List<Int>, bonusInput: String) : Int {
        try {
            val bonusNumber = bonusInput.toInt()
            require(bonusNumber in 1 .. 45) { "[ERROR] 1~45 사이의 숫자를 입력하셔야 합니다." }
            require(!winningNumberList.contains(bonusNumber)) { "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다." }
        } catch (exception: NumberFormatException){
            throw IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.")
        }
        return bonusInput.toInt()
    }
}