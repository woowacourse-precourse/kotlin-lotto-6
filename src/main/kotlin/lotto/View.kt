package lotto

import camp.nextstep.edu.missionutils.Console

class View {
    private val validation = Validation()

    fun printInputPaymentMessage(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return validation.checkInputPayment(input)
    }
}
