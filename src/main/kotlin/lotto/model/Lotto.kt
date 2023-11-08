package lotto.model

import lotto.toValidInt

class Lotto(private val numbers: List<LottoNumber>) {

    init {
        validateSize()
        validateDuplicatedNumber()
    }

    fun isMatchedBonus(bonus: LottoNumber): Boolean = numbers.contains(bonus)

    fun getMatchCount(lotto: Lotto): Int = numbers.count { ball -> lotto.numbers.contains(ball) }

    fun toStringNumbers(): String = numbers.toString()

    private fun validateSize() {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_ERROR }
    }

    private fun validateDuplicatedNumber() {
        require(numbers.toSet().size == numbers.size) { DUPLICATED_NUMBER_ERROR }
    }

    companion object {
        private const val SEPARATOR = ","
        private const val LOTTO_NUMBER_SIZE = 6
        private const val INVALID_SIZE_ERROR = "로또 값이 6개가 아닙니다."
        private const val DUPLICATED_NUMBER_ERROR = "동일한 숫자는 값으로 입력할 수 없습니다. 로또 값이 중복되지 않았는지 확인해주세요."

        fun create(userInput: String): Lotto {
            val balls = userInput.split(SEPARATOR).map { number -> number.trim().toValidInt() }.toLottoNumbers()
            return Lotto(balls)
        }

        fun of(vararg balls: Int) = Lotto(balls.toList().toLottoNumbers())
    }
}