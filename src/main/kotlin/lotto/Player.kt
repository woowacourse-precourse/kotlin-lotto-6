package lotto

import camp.nextstep.edu.missionutils.Console

private const val LOTTO_UNIT = 1_000

class Player {

    fun inputPurchaseAmount(): Int {
        val amount = Console.readLine()
        validatePurchaseAmount(amount)
        return amount.toInt()
    }

    fun calculateLottoGenerateCount(amount: Int): Int {
        return amount / LOTTO_UNIT
    }

    private fun validatePurchaseAmount(amount: String) {
        val purchaseAmount = amount.toIntOrNull() ?: throw IllegalArgumentException(INPUT_TYPE_ERROR)
        require(purchaseAmount % LOTTO_UNIT == 0) { throw IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR) }
    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT_ERROR = "[ERROR] 1000원 단위로 입력해야 합니다."
        const val INPUT_TYPE_ERROR = "[ERROR] 숫자로 입력해야 합니다."
    }

}