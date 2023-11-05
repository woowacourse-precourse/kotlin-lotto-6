package lotto.validator

class BonusNumberValidator {
    fun validate(inputBonusNumber: String, winningNumbers: List<Int>) {
        val bonusNumber = parseToInt(inputBonusNumber)
        requireValidNumberRange(bonusNumber)
        requireUniqueNumber(bonusNumber, winningNumbers)
    }

    private fun parseToInt(inputBonusNumber: String): Int {
        return try {
            inputBonusNumber.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자가 아닌 다른 형식을 입력할 수 없습니다.")
        }
    }

    private fun requireValidNumberRange(inputBonusNumber: Int) {
        require(inputBonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    private fun requireUniqueNumber(inputBonusNumber: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(inputBonusNumber)) { "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다." }
    }
}