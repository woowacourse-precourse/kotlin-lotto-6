package lotto.domain

import camp.nextstep.edu.missionutils.Console

class Store {
    private var cost: Int = 0
    private var totalSold: Int = 0
    fun payToBuy(): Int {
        println("구입금액을 입력해 주세요.")
        cost = validatePayment()
        return totalSold
    }


    private fun validatePayment(): Int {
        while (true) {
            try {
                val paymentCheck = Console.readLine().toIntOrNull()
                require(paymentCheck != null) { ValidatorPayment.INVALID_FORMAT.message }
                require(paymentCheck > 0) { ValidatorPayment.INVALID_RANGE.message }
                require(paymentCheck % 1000 == 0) { ValidatorPayment.INVALID_AMOUNT.message }

                return paymentCheck.also {
                    printSuccessMessage(howManyLotto(it))
                }

            } catch (e: IllegalArgumentException) {
                printErrorMessage(e.message ?: "[ERROR] Invalid input")
            }
        }
    }

    private fun printSuccessMessage(count: Int) {
        println("\n${count}개를 구매했습니다.")
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }

    private fun howManyLotto(money: Int): Int {
        totalSold = money / 1000
        return totalSold
    }
}