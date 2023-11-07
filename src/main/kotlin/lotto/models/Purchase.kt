package lotto.models

import lotto.User

class Purchase(private val amount: Int) {

    init {

    }

    fun getAmount() = amount

    companion object {
        const val AMOUNT_UNIT = 1000
        const val INVALID_AMOUNT_ERROR_MESSAGE = "금액은 ${User.AMOUNT_UNIT} 단위의 숫자만 입력이 가능합니다."
    }
}