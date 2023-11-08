package lotto.utils

import lotto.domain.Lotto

class UserInputException {
    companion object {
        fun purchaseAmountException(userInput: String): Int {
            require(isNumber(userInput)) { Constants.ERROR_LOTTO_NOT_NUMBER }
            require(userInput.toInt() % 1000 == 0) { Constants.ERROR_MONEY_UNIT }
            return userInput.toInt()
        }

        fun lottoException(userInput: String): List<Int> {
            val lottoList = userInput.split(Constants.SEPARATOR)
            require(lottoSizeException(lottoList)) { Constants.ERROR_LOTTO_NUMBER_SIZE }
            require(lottoNumberException(lottoList)) { Constants.ERROR_LOTTO_NOT_NUMBER }
            val lottoNumberList = lottoList.map { it.toInt() }
            require(lottoNumberDuplicateException(lottoNumberList)) { Constants.ERROR_LOTTO_NUMBER_DUPLICATE }
            require(lottoNumberOutOfRangeException(lottoNumberList)) { Constants.ERROR_LOTTO_NUMBER_RANGE }

            return lottoNumberList
        }

        fun bonusNumberException(userInput: String): Int {
            require(isNumber(userInput)) { Constants.ERROR_LOTTO_NOT_NUMBER }
            val bonusNumber = userInput.toInt()
            require(bonusNumberOutOfRange(bonusNumber)) { Constants.ERROR_LOTTO_NUMBER_RANGE }

            return bonusNumber
        }

        private fun isNumber(userInput: String): Boolean {
            for (numberIndex in 0 until userInput.length) {
                if (userInput[numberIndex].code < '0'.code || userInput[numberIndex].code > '9'.code) {
                    return false
                }
            }
            return true
        }

        private fun lottoSizeException(lottoList: List<String>): Boolean {
            return lottoList.size == Constants.LOTTO_NUMBER_SIZE
        }

        private fun lottoNumberException(lottoNumberList: List<String>): Boolean {
            return lottoNumberList.all { it.toIntOrNull() != null }
        }

        private fun lottoNumberDuplicateException(lottoNumberList: List<Int>): Boolean {
            return lottoNumberList.size == lottoNumberList.distinct().size
        }

        private fun lottoNumberOutOfRangeException(lottoNumberList: List<Int>): Boolean {
            return lottoNumberList.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }
        }

        private fun bonusNumberOutOfRange(bonusNumber: Int): Boolean {
            return (bonusNumber in Constants.MIN_NUMBER..Constants.MAX_NUMBER)
        }
    }
}