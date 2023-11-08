package lotto.domain

class WinningNum(private val winningNum: String) {
    init {
        require(isValidFormat()) { println(IS_VALID_FORMAT) }
    }

    private fun isValidFormat(): Boolean =
        winningNum.split(",").map { it.trim() }.all { it.matches(Regex("""^\d+(,\d+)*$""")) }


    companion object {
        private const val IS_VALID_FORMAT = "[ERROR] 당첨 번호 입력 시 콤마와 숫자로 이루어진 문자열로 입력해야 합니다."
    }
}

