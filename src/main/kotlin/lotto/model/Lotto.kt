package lotto.model

import lotto.Constants
import lotto.model.dto.LottoResult
import lotto.model.validation.LottoNumber

/*
    요구 사항 : 제공된 Lotto 클래스를 활용해 구현해야 한다.
    1. _numbers의 접근 제어자 private를 변경할 수 없다.
    2. Lotto에 필드를 추가할 수 없다.
    3. Lotto의 패키지 변경은 가능하다.
*/
open class Lotto(private val _numbers: List<Int>) {
    val numbers: List<LottoNumber> get() = _numbers.map { LottoNumber(it.toString()) }

    init {
        validateSize()
        validateDuplicate()
    }

    protected fun validateSize() =
        require(_numbers.size == Constants.LOTTO_NUMBER_SIZE) { LOTTO_NUMBERS_OUT_OF_SIZE }

    protected fun validateDuplicate() =
        require(_numbers.size == _numbers.toSet().size) { LOTTO_NUMBERS_NON_DUPLICATE }

    override fun toString(): String {
        return "$_numbers"
    }

    fun calculate(
        winningnumbers: List<LottoNumber>,
        bonusNumber: LottoNumber
    ): LottoResult {
        var winningMatchCount = 0
        val numbers = this.numbers
        val bonusMatch = numbers.count { it == bonusNumber }

        for (num in numbers) {
            if (winningnumbers.contains(num)) {
                winningMatchCount += 1
            }
        }
        return LottoResult(winningMatchCount, bonusMatch)
    }

    companion object {
        const val LOTTO_NUMBERS_OUT_OF_SIZE = "로또 번호는 6개의 숫자로 이루어져야 합니다."
        const val LOTTO_NUMBERS_NON_DUPLICATE = "로또 번호는 중복될 수 없습니다."
    }
}