package lotto

import camp.nextstep.edu.missionutils.Console

class Player {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val amount = Console.readLine().toInt()
        validatePurchaseAmount(amount)
        return amount
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.") }
    }
}