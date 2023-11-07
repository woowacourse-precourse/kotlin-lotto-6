package lotto.constant

class Exception {
    companion object {
        const val MESSAGE_EXCEPT_RANGE_AMOUNT = "[ERROR] 1000원 이상으로 구입 가능합니다."
        const val MESSAGE_EXCEPT_AMOUNT = "[ERROR] 구입 금액은 1000원 단위입니다."
        const val MESSAGE_EXCEPT_LENGTH_WINNING_NUMBER = "[ERROR] 6개의 숫자를 입력해주세요."
        const val MESSAGE_EXCEPT_DUPLICATE  = "[ERROR] 숫자를 중복 없이 입력해주세요."
        const val MESSAGE_EXCEPT_RANGE = "[ERROR] 1이상 45이하의 숫자를 입력해주세요."
        const val MESSAGE_EXCEPT_DIGIT = "[ERROR] 1이상 45이하의 숫자를 입력해주세요."
        const val MESSAGE_EXCEPT_DUPLICATE_BONUS_WINNING_NUMBER = "[ERROR] 당첨 번호와 중복되지 않게 입력해주세요."
    }
}