package lotto.exception

class BonusValidation(private val lotto: List<Int>, private val bonus: String) {

    init {
        validateBonusRange()
        validateBonusNumber()
        validateBonusDuplicate()
    }

    private fun validateBonusRange() {
        require(bonus.toInt() in 1..45) {
            "[ERROR] 1~45 사이의 숫자만 가능합니다."
        }
    }

    private fun validateBonusNumber() {
        val length = bonus.length
        require(bonus.matches(Regex("[0-9]{$length}"))) {
            "[ERROR] 숫자만 입력해주세요."
        }
    }

    private fun validateBonusDuplicate() {
        repeat(lotto.size) {
            require(lotto[it] != bonus.toInt()) {
                "[ERROR] 로또 입력값과 보너스 번호의 값이 중복됩니다. 다른 값을 입력해주세요."
            }
        }
    }
}