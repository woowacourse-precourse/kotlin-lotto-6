package lotto.utils

import lotto.domain.Lotto

class UserInputException {
    companion object {
        private const val PICK_NUMBER = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        fun purchaseAmountException(userInput: String): Int {
            require(isNumber(userInput)) { "[ERROR] 입력 값은 숫자여야 합니다." }
            require(userInput.toInt() % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
            return userInput.toInt()
        }

        fun lottoException(userInput: String): List<Int> {
            val lottoList = userInput.split(",")
            require(lottoSizeException(lottoList)) { "[ERROR] 로또 번호의 수는 6개여야 합니다." }
            require(lottoNumberException(lottoList)) { "[ERROR] 로또 번호는 숫자여야 합니다." }
            val lottoNumberList = lottoList.map { it.toInt() }
            require(lottoNumberDuplicateException(lottoNumberList)) { "[ERROR] 로또 번호는 중복된 값이 있으면 안됩니다." }
            require(lottoNumberOutOfRangeException(lottoNumberList)) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }

            return lottoNumberList
        }

        fun bonusNumberException(userInput: String): Int {
            require(isNumber(userInput)) { "[ERROR] 입력 값은 숫자여야 합니다." }
            val bonusNumber = userInput.toInt()
            require(bonusNumberOutOfRange(bonusNumber)) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }

            return bonusNumber
        }

        fun isNumber(userInput: String): Boolean {
            for (numberIndex in 0 until userInput.length) {
                if (userInput[numberIndex].code < '0'.code || userInput[numberIndex].code > '9'.code) {
                    return false
                }
            }
            return true
        }

        fun lottoSizeException(lottoList: List<String>): Boolean {
            return lottoList.size == PICK_NUMBER
        }

        fun lottoNumberException(lottoNumberList: List<String>): Boolean {
            return lottoNumberList.all { it.toIntOrNull() != null }
        }

        fun lottoNumberDuplicateException(lottoNumberList: List<Int>): Boolean {
            return lottoNumberList.size == lottoNumberList.distinct().size
        }

        fun lottoNumberOutOfRangeException(lottoNumberList: List<Int>): Boolean {
            return lottoNumberList.all { it in MIN_NUMBER..MAX_NUMBER }
        }

        fun bonusNumberOutOfRange(bonusNumber: Int): Boolean {
            return (bonusNumber in MIN_NUMBER..MAX_NUMBER)
        }
    }
}