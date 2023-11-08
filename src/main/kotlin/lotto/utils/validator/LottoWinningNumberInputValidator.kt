package lotto.utils.validator

class LottoWinningNumberInputValidator {
    private val errorMessages: HashMap<LottoInputState.WinningNumber, String> = hashMapOf()

    init {
        errorMessages[LottoInputState.WinningNumber.HAS_DUPLICATE] = "[ERROR]중복된 번호가 존재합니다."
        errorMessages[LottoInputState.WinningNumber.OUT_OF_RANGE] =
            "[ERROR]값의 범위에서 벗어났습니다. 로또 번호는 1 ~ 45 까지의 자연수만 입력 가능합니다."
        errorMessages[LottoInputState.WinningNumber.IS_NULL] = "[ERROR]유효한 값이 아닙니다. 로또 번호는 1 ~ 45 까지의 자연수만 입력 가능합니다."
        errorMessages[LottoInputState.WinningNumber.NUMBERS_SIZE_IS_NOT_SIX] = "[ERROR]당첨 번호는 6개이어야 합니다."
    }

    fun validate(numbers: List<String>): Boolean {
        var state: LottoInputState.WinningNumber = getNumbersState(numbers)
        if (state != LottoInputState.WinningNumber.SUCCESSFUL) {
            displayErrorMessage(state)
            throw IllegalArgumentException()
        }
        return validateNumbers(numbers)
    }

    fun validate(numbers: List<Int>, bonusNumber: String): Boolean {
        if (hasNumberDuplicates(numbers, bonusNumber)) {
            displayErrorMessage(LottoInputState.WinningNumber.HAS_DUPLICATE)
            throw IllegalArgumentException()
        }
        var numberState = getNumberState(bonusNumber.toIntOrNull())
        if (numberState != LottoInputState.WinningNumber.SUCCESSFUL) {
            displayErrorMessage(numberState)
            throw IllegalArgumentException()
        }
        return true
    }

    private fun validateNumbers(numbers: List<String>): Boolean {
        var numberState: LottoInputState.WinningNumber = LottoInputState.WinningNumber.SUCCESSFUL
        numbers.forEach {
            numberState = getNumberState(it.toIntOrNull())
            if (numberState != LottoInputState.WinningNumber.SUCCESSFUL) {
                displayErrorMessage(numberState)
                throw IllegalArgumentException()
            }
        }
        return true
    }

    private fun getNumberState(number: Int?): LottoInputState.WinningNumber {
        return when {
            number == null -> LottoInputState.WinningNumber.IS_NULL
            number <= 0 || number > 45 -> LottoInputState.WinningNumber.OUT_OF_RANGE
            else -> LottoInputState.WinningNumber.SUCCESSFUL
        }
    }

    private fun getNumbersState(numbers: List<String>): LottoInputState.WinningNumber {
        return when {
            numbers.size != 6 -> LottoInputState.WinningNumber.NUMBERS_SIZE_IS_NOT_SIX
            hasNumberDuplicates(numbers) -> LottoInputState.WinningNumber.HAS_DUPLICATE
            else -> LottoInputState.WinningNumber.SUCCESSFUL
        }
    }

    private fun displayErrorMessage(error: LottoInputState.WinningNumber) {
        println(errorMessages[error])
    }

    private fun hasNumberDuplicates(winningNumbers: List<String>): Boolean {
        val allNumbers = winningNumbers.toHashSet()
        if (winningNumbers.size != allNumbers.size) {
            return true
        }
        return false
    }

    private fun hasNumberDuplicates(winningNumbers: List<Int>, bonusNumber: String): Boolean {
        val allNumbers = winningNumbers.toMutableSet()
        bonusNumber.toIntOrNull()?.let {
            allNumbers.add(it)
            if (winningNumbers.size + 1 != allNumbers.size) {
                return true
            }
        }
        return false
    }

}