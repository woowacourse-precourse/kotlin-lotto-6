package lotto.domain

import camp.nextstep.edu.missionutils.Console

class Store {
    private var cost: Int = 0
    private var totalSold: Int = 0
    fun payToBuy(): Int {
        println(INPUT_COST_MESSAGE)
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
                printErrorMessage(e.message ?: DEFAULT_ERROR)
            }
        }
    }

    private fun printSuccessMessage(count: Int) {
        println(LOTTO_COUNT_MESSAGE.format(count))
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }

    private fun howManyLotto(money: Int): Int {
        totalSold = money / LOTTO_PRICE
        return totalSold
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val INPUT_COST_MESSAGE = "구입금액을 입력해 주세요."
        private const val LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다."
        private const val DEFAULT_ERROR = "[ERROR] Invalid input"
    }
}