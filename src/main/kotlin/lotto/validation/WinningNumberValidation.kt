package lotto.validation

enum class WinningNumberValidation(private val errorMessage: String) {
    VALIDATION_START("Validation Start"),
    EMPTY_NUMBER("[ERROR] 값을 입력하지 않았습니다. 값을 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백이 포함되어 있습니다. 공백은 입력할 수 없습니다."),
    NUMBER_NOT_CORRECT("[ERROR] 당첨 번호는 6개 입력해 주세요."),
    NOT_NUMBER("[ERROR] 로또 번호는 숫자로 이루어져야 합니다."),
    OUT_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호가 중복되었습니다.");


    fun getMessage(numbers: String) {
        val winningNumbers = numbers.split(SPLIT_CHAR)
        when {
            numbers.isEmpty() -> throw IllegalArgumentException(EMPTY_NUMBER.errorMessage)
            winningNumbers.size != NUMBER_SIZE -> throw IllegalArgumentException(NUMBER_NOT_CORRECT.errorMessage)
            winningNumbers.toSet().size != NUMBER_SIZE -> throw IllegalArgumentException(DUPLICATE_NUMBER.errorMessage)
        }
        winningNumbers.forEach { number ->
            when {
                number.contains(" ") -> throw IllegalArgumentException(INCLUDE_BLANK.errorMessage)
                !number.matches(Regex("\\d+")) -> throw IllegalArgumentException(NOT_NUMBER.errorMessage)
                number.toInt() !in (MIN_NUMBER..MAX_NUMBER) ->
                    throw IllegalArgumentException(OUT_NUMBER_RANGE.errorMessage)
            }
        }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val NUMBER_SIZE = 6
        private const val SPLIT_CHAR = ","
    }
}