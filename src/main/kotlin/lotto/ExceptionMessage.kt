package lotto

class ExceptionMessage {
    companion object {
        const val NOT_DUPLICATED_NUMBER = "[ERROR] 중복된 번호가 올 수 없습니다."
        const val NOT_LOTTO_NUMBER_IN_RANGE = "[ERROR] 로또 번호는 1에서 45 사이에 있어야 합니다."
        const val NOT_NUMBER = "[ERROR] 입력하신 값은 숫자가 아닙니다."
        const val NOT_CORRECT_PRICE = "[ERROR] 입력하신 가격으로 로또를 구매할 수 없습니다."
        const val NOT_CORRECT_SIZE = "[ERROR] 입력하신 번호의 개수가 6개가 아닙니다."
        const val BONUS_NUMBER_DUPLICATED = "[ERROR] 입력하신 번호는 당첨 번호와 중복됩니다. 다시 입력해주세요."
    }
}