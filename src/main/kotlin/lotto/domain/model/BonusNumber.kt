package lotto.domain.model

@JvmInline
value class BonusNumber(val number: Int) {
    init {
        require(number in Lotto.validRange) { NUMBER_NOT_IN_VALID_RANGE_MESSAGE }
    }

    companion object {
        const val NUMBER_NOT_IN_VALID_RANGE_MESSAGE = "숫자가 ${Lotto.MIN_NUMBER}~${Lotto.MAX_NUMBER} 사이에 존재해야 합니다."
        const val NUMBER_EXISTS_IN_WINNING_NUMBERS = "이미 숫자가 당첨 번호에 존재합니다."
    }
}