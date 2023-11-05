package lotto.domain

import camp.nextstep.edu.missionutils.Console

class Store {
    private var cost: Int = 0
    fun payToBuy() {
        println("구입금액을 입력해 주세요.")
        cost = validatePayment()
    }

    private fun validatePayment(): Int {
        while (true) {
            val payMoney = Console.readLine()
            val validationResult = ValidatorPayment.checkMoney(payMoney)
            if (validationResult.isValid) {
                return payMoney.toInt().also {
                    printSuccessMessage(howManyLotto(it))
                }
            }
            printErrorMessage(validationResult.message)
        }
    }

    private fun printSuccessMessage(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }

    private fun howManyLotto(money: Int): Int {
        return money / 1000
    }
}