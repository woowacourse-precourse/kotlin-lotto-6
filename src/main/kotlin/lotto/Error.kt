package lotto

object Error {
    const val MESSAGE_HEADER = "[ERROR] "
    const val LOTTO_NUMBER_SIZE_IS_NOT_SIX = "로또 번호는 6개의 정수여야 합니다."
    const val LOTTO_NUMBER_TYPE_IS_NOT_INT = "로또 번호의 타입은 정수여야 합니다."
    const val LOTTO_NUMBER_IS_OUT_OF_RANGE = "로또 번호는 1~45사이의 정수여야 합니다."
    const val BONUS_NUMBER_CANT_EQUAL_LOTTO_NUMBER = "보너스 번호와 로또 당첨 번호는 같을 수 없습니다."
    const val LOTTO_NUMBER_CANT_DUPLICATE = "로또 번호는 중복될 수 없습니다."
    const val PRICE_TYPE_IS_NOT_INT = "구입 금액은 정수여야 합니다."
    const val PRICE_IS_UNDER_1000 = "구입 금액은 1000원 이상이어야 합니다."
    const val PRICE_IS_NOT_PRODUCT_OF_1000 = "구입 금액은 1000원으로 나누어 떨어져야 합니다."

    fun printErrorMessage(msg: String) {
        println(MESSAGE_HEADER + msg)
    }
}