package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoTicket
import lotto.util.LottoGenerator
import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateRange

fun main() {
    printGameStartMessage()
    val purchaseCount = getValidateUserInput() / 1000
    val lottoTicket = LottoTicket(purchaseCount)
    val lottoGenerator = LottoGenerator()
    println()
    printPurchaseCount(purchaseCount)
    repeat(purchaseCount) {
        val numbers = lottoGenerator.lottoPublish()
        lottoTicket.addNumbers(numbers)
    }
    printLottoTicket(lottoTicket)
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

fun printPurchaseCount(purchaseCount: Int) {
    println("${purchaseCount}개를 구매했습니다.")
}

fun printLottoTicket(lottoTicket: LottoTicket) {
    val ticket = lottoTicket.numbers
    repeat(ticket.size) {index ->
        println(ticket[index].toString())
    }
}