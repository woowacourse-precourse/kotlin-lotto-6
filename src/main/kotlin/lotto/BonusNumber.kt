package lotto

class BonusNumber(private val number: String, val lotto: Lotto) {

    init {
        require(number.toIntOrNull() == null) { NOT_NUMBER_ERROR }
        require(isContains()) { DUPLICATED_NUMBER_ERROR }
    }

    private fun isContains(): Boolean {
        val lotto = lotto.getLottoNumbers()
        val bonusNumber = number.toInt()
        return !lotto.contains(bonusNumber)
    }

    companion object {
        const val NOT_NUMBER_ERROR = "[ERROR] 숫자만 입력해주세요"
        const val DUPLICATED_NUMBER_ERROR = "[ERROR] 중복된 숫자입니다."
    }
}