package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.isUnique())
        require(numbers.isAllLottoNumberInRange())
    }

    // TODO: 추가 기능 구현
    fun getNumbers() = numbers

    companion object {
        const val LOTTO_PRICE_PER_GAME = 1000
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_NUMBERS_COUNT = 6

        fun generateRandomLottoNumbers(): Lotto {
            return Lotto(
                Randoms.pickUniqueNumbersInRange(
                    LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_COUNT
                )
            )
        }
    }
}

fun List<Int>.isUnique(): Boolean {
    return this.size == this.distinct().size
}

fun List<Int>.isAllLottoNumberInRange(): Boolean {
    return this.filterNot { number -> number.isLottoNumberInRange() }.isEmpty()
}

fun Int.isLottoNumberInRange(): Boolean {
    return this in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER
}