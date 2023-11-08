package lotto.utils

class Constants {
    companion object {
        const val LOTTO_PRICE = 1000
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_NUMBER_SIZE = 6
        const val SEPARATOR = ","
        const val ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호의 수는 6개여야 합니다."
        const val ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERROR_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복된 값이 있으면 안됩니다."
        const val ERROR_LOTTO_NOT_NUMBER = "[ERROR] 입력 값은 숫자여야 합니다."
        const val ERROR_MONEY_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
    }
}