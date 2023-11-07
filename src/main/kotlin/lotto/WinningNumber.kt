package lotto

class WinningNumber(private val numbers: String) {

    init {
        require(checkNumbersOfCommas()) { "$ERROR $PLEASE_SEPARATE_NUMBERS_COMMAS" }
    }

    private fun checkNumbersOfCommas(): Boolean {
        return numbers.count { it == ',' } == 5
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val PLEASE_SEPARATE_NUMBERS_COMMAS = "당첨 번호는 쉼표(,) 기준으로 구분해주세요."
    }

}