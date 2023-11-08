package lotto.model

import lotto.model.validator.LottoValidator
import lotto.toValidInt

class Lotto(private val numbers: List<LottoNumber>) {

    fun isMatchedBonus(bonus: LottoNumber): Boolean = numbers.contains(bonus)

    fun getMatchCount(lotto: Lotto): Int = numbers.count { ball -> lotto.numbers.contains(ball) }

    fun toStringNumbers(): String = numbers.toString()

    companion object {
        private const val SEPARATOR = ","

        fun create(userInput: String, validator: LottoValidator = LottoValidator()): Lotto {
            val numbers = userInput.split(SEPARATOR).map { number -> number.trim().toValidInt() }.toLottoNumbers()
            validator.validate(numbers)
            return Lotto(numbers)
        }

        fun of(vararg balls: Int, validator: LottoValidator = LottoValidator()): Lotto {
            val numbers = balls.toList().toLottoNumbers()
            validator.validate(numbers)
            return Lotto(numbers)
        }
    }
}