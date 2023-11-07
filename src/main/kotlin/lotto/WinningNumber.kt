package lotto

class WinningNumber(private val numbers: String) {

    private val winningNumbers = numbers.split(",")

    init {
        require(checkNumbersOfCommas()) { "$ERROR $PLEASE_SEPARATE_NUMBERS_COMMAS" }
        require(isNumberOrNull()) { "$ERROR $INPUT_ONLY_NUMBER" }
    }

    private fun checkNumbersOfCommas(): Boolean {
        return numbers.count { it == ',' } == 5
    }

    private fun isNumberOrNull(): Boolean {
        return winningNumbers.all { it.toIntOrNull() != null }
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val PLEASE_SEPARATE_NUMBERS_COMMAS = "당첨 번호는 쉼표(,) 기준으로 구분해주세요."
        const val INPUT_ONLY_NUMBER = "당첨 번호는 숫자만 입력 가능합니다."
    }

}