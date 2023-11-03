package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateRange

fun main() {

}

fun printGameStartMessage() {
    println("구입금액을 입력해 주세요.")
}

fun getUserInput(): String = Console.readLine()

fun getValidateUserInput(): Int {
    val userInput = getUserInput()
    validateInteger(userInput)
    validateRange(userInput)
    validate1000Unit(userInput)
    return userInput.toInt()
}

fun printBuyCountMessage(count: Int) {
    println("${count}개를 구매했습니다.")
}