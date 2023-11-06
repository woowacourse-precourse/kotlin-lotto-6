package lotto.exception


class ExceptionChecker {

    fun checkAmount(amount: String) {
        isDigitNumber(amount)
        isEnough(amount.toInt())
        isDollarUnit(amount.toInt())
    }

    private fun isDigitNumber(amount: String) {
        if (amount == "") throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
        for (character in amount) {
            if (!character.isDigit()) {
                throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
            }
        }
    }

    private fun isEnough(amount: Int) {
        if (amount < 1000) {
            throw IllegalArgumentException("[ERROR] 금액이 부족합니다.")
        }

    }

    private fun isDollarUnit(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해주세요.")
        }
    }

    fun checkWinningNumbers(numbers: List<String>) {
        isDigit(numbers)
        isValidSize(numbers)
        isDuplicate(numbers)
        isInRange(numbers.map { it.toInt() })
    }

    private fun isDigit(numbers: List<String>) {
        for (number in numbers) {
            //isDigitNumber(number)
        }
    }

    private fun isValidSize(numbers: List<String>) {
        if (numbers.size != 6) throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요")
    }

    private fun isDuplicate(numbers: List<String>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException("[ERROR] 중복된 수가 존재합니다.")
        }
    }

    private fun isInRange(numbers: List<Int>) {
        for (number in numbers) {
            if (number < 1 || number > 45) throw IllegalArgumentException("[ERROR] 1부터 45 사이의 수를 입력해주세요")
        }
    }

    private fun isInRange(number: Int) {
        if (number < 1 || number > 45) throw IllegalArgumentException("[ERROR] 1부터 45 사이의 수를 입력해주세요")

    }

    fun checkBonusNumber(winningNumbers: List<Int>, bonusNumber: String) {
        isDigitNumber(bonusNumber)
        isDuplicate(winningNumbers, bonusNumber.toInt())
        isInRange(bonusNumber.toInt())
    }

    private fun isDuplicate(winningNumbers:List<Int>, bonusNumber: Int) {
        if(winningNumbers.contains(bonusNumber)) throw IllegalArgumentException("[ERROR] 중복된 수가 존재합니다.")
    }


}