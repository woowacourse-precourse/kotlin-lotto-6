package lotto

class BonusNumber(private val number: String, val lotto: Lotto) {

    init {
        require(number.toIntOrNull() == null) { NOT_NUMBER_ERROR }
        require(isContains()) { DUPLICATED_NUMBER_ERROR }
        require(isNumberInRange()) {NOT_IN_RANGE_ERROR}
    }

    private fun isNumberInRange(): Boolean {
        return number.toInt() in 1..45
    }

    private fun isContains(): Boolean {
        val lotto = lotto.getLottoNumbers()
        val bonusNumber = number.toInt()
        return !lotto.contains(bonusNumber)
    }

    fun getBonusNumber(): Int {
        return number.toInt()
    }

    companion object {
        const val NOT_NUMBER_ERROR = "[ERROR] 숫자만 입력해주세요"
        const val DUPLICATED_NUMBER_ERROR = "[ERROR] 중복된 숫자입니다."
        const val NOT_IN_RANGE_ERROR = "[ERROR] 1 부터 45 사이의 수를 입력해주세요"
    }
}