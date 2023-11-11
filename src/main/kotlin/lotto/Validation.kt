package lotto

class Validation {
    fun purchaseMoneyValidation(purchaseMoney: String) {
        return checkValidPurchaseMoney(purchaseMoney)
    }

    fun winningNumbersValidation(lottoNumber: String) {
        return checkValidWinningNumbers(lottoNumber)
    }

    fun bonusNumberValidation(winningNumbers: List<Int>, bounusNumber: String) {
        return checkValidBonusNumber(winningNumbers,bounusNumber)
    }

    fun purchaseMoneyErrorMessage() {
        println("[ERROR] 1000의 배수를 입력 받아야 합니다.")
        println()
    }

    fun winningNumbersErrorMessage() {
        println("[ERROR] 로또 숫자는 중복되지 않는 6개의 1~45 사이의 숫자로 이루어 져야 합니다.")
        println()
    }

    fun bonusNumberErrorMessage() {
        println("[ERROR] 보너스 숫자는 로또 숫자와 중복되지 않는 1~45 사이의 숫자이어야 합니다.")
        println()
    }

    private fun checkValidPurchaseMoney(purchaseMoney: String) {
        val purchaseMoneyToInt = purchaseMoney.toIntOrNull()
        require(purchaseMoneyToInt != null)
        require(purchaseMoneyToInt % LOTTO_PRICE == 0)
    }

    private fun checkValidWinningNumbers(lottoNumber: String) {
        val numbersList = lottoNumber.split(",")
        require(numbersList.distinct().size == LOTTO_NUMBERS)
        for (number in numbersList) {
            val numberToInt = number.toIntOrNull()
            require(numberToInt != null)
            require(numberToInt in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        }
    }

    private fun checkValidBonusNumber(winningNumbers: List<Int>, bonusNumber: String) {
        val bonusNumberToInt = bonusNumber.toIntOrNull()
        require(bonusNumberToInt != null)
        require(bonusNumberToInt in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        require(!winningNumbers.contains(bonusNumberToInt))
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBERS = 6
        const val LOTTO_PRICE = 1000
    }
}