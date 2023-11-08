package lotto.utils.validator

class LottoWinningNumberInputValidator {

    fun validate(numbers: List<String>): Boolean {
        var numberState: LottoInputState.WinningNumber

        if (numbers.size != 6) {
            displayErrorMessage(LottoInputState.WinningNumber.NUMBERS_SIZE_IS_NOT_SIX)
            throw IllegalArgumentException()
        }
        if (hasNumberDuplicates(numbers)){
            displayErrorMessage(LottoInputState.WinningNumber.HAS_DUPLICATE)
            throw IllegalArgumentException()
        }

        numbers.forEach {
            numberState = getState(it.toIntOrNull())
            if (numberState != LottoInputState.WinningNumber.SUCCESSFUL) {
                displayErrorMessage(numberState)
                throw IllegalArgumentException()
            }
        }
        return true
    }

    fun validate(numbers: List<Int>, bonusNumber: String): LottoInputState.WinningNumber {
        if (hasNumberDuplicates(numbers,bonusNumber)){
            displayErrorMessage(LottoInputState.WinningNumber.HAS_DUPLICATE)
            throw IllegalArgumentException()
        }

        var numberState = getState(bonusNumber.toIntOrNull())
        if (numberState != LottoInputState.WinningNumber.SUCCESSFUL) {
            displayErrorMessage(numberState)
            throw IllegalArgumentException()
        }
        return numberState
    }

    private fun getState(number: Int?): LottoInputState.WinningNumber {
        return when {
            number == null -> LottoInputState.WinningNumber.IS_NULL
            number <= 0 || number > 45 -> LottoInputState.WinningNumber.OUT_OF_RANGE
            else -> LottoInputState.WinningNumber.SUCCESSFUL
        }
    }

    private fun displayErrorMessage(error: LottoInputState.WinningNumber) {
        var errorMessage = ""
        when (error) {
            LottoInputState.WinningNumber.OUT_OF_RANGE -> {
                errorMessage = "[ERROR]값의 범위에서 벗어났습니다. 로또 번호는 1 ~ 45 까지의 자연수만 입력 가능합니다."
            }

            LottoInputState.WinningNumber.IS_NULL -> {
                errorMessage = "[ERROR]유효한 값이 아닙니다. 로또 번호는 1 ~ 45 까지의 자연수만 입력 가능합니다."
            }

            LottoInputState.WinningNumber.NUMBERS_SIZE_IS_NOT_SIX -> {
                errorMessage = "[ERROR]당첨 번호는 6개이어야 합니다."
            }
            LottoInputState.WinningNumber.HAS_DUPLICATE -> {
                errorMessage = "[ERROR]중복된 번호가 존재합니다."
            }

            else -> {}
        }
        println(errorMessage)
    }

    private fun hasNumberDuplicates(winningNumbers : List<String>): Boolean {
        val allNumbers = winningNumbers.toHashSet()
        if (winningNumbers.size != allNumbers.size) {
            return true
        }
        return false
    }

    private fun hasNumberDuplicates(winningNumbers : List<Int>, bonusNumber: String): Boolean {
        val allNumbers = winningNumbers.toMutableSet()
        bonusNumber.toIntOrNull()?.let {
            allNumbers.add(it)
            if (winningNumbers.size+1 != allNumbers.size) {
                return true
            }
        }
        return false
    }

}