package lotto.validation

enum class BonusNumberValidation(private val errorMessage: String) {
    ERROR_MESSAGE("Validation Start"),
    EMPTY_NUMBER("[ERROR] 값을 입력하지 않았습니다. 값을 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백이 포함되어 있습니다. 공백을 제외하고 입력해 주세요"),
    BONUS_MORE_ONE("[ERROR] 보너스 번호는 하나만 입력 가능합니다."),
    NOT_NUMBER("[ERROR] 보너스 번호는 숫자로 입력하셔야 합니다."),
    OUT_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    fun getErrorMessage(bonusNumber: String) {
        when {
            bonusNumber.isEmpty() -> throw IllegalArgumentException(EMPTY_NUMBER.errorMessage)
            bonusNumber.contains(",") -> throw IllegalArgumentException(BONUS_MORE_ONE.errorMessage)
            bonusNumber.contains(" ") -> throw IllegalArgumentException(INCLUDE_BLANK.errorMessage)
            !bonusNumber.matches(Regex("\\d+")) -> throw IllegalArgumentException(NOT_NUMBER.errorMessage)
            bonusNumber.toInt() !in (START_NUMBER..END_NUMBER) ->
                throw IllegalArgumentException(OUT_NUMBER_RANGE.errorMessage)
        }
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
    }
}