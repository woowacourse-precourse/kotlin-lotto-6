package lotto

import camp.nextstep.edu.missionutils.Console

private const val LOTTO_UNIT = 1000

class Player {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val amount = Console.readLine().toInt()
        validatePurchaseAmount(amount)
        return amount
    }

    fun calculateLottoGenerateCount(amount: Int): Int {
        val generateCount = amount / LOTTO_UNIT
        println("${generateCount}개를 구매했습니다.")
        return generateCount
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % LOTTO_UNIT == 0) { throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.") }
    }
}