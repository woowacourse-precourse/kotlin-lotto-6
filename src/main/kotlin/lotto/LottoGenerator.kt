package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    private lateinit var lotto: Lotto

    fun get(): Lotto {
        generateLotto()

        return this.lotto
    }

    fun get(numbers: List<Int>): Lotto {
        convertToLotto(numbers)

        return this.lotto
    }

    private fun generateLotto() {
        this.lotto = Lotto(generatedLottoNumber())
    }

    private fun generatedLottoNumber() = Randoms.pickUniqueNumbersInRange(
        Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_NUMBER_COUNT
    )

    private fun convertToLotto(numbers: List<Int>) {
        this.lotto = Lotto(numbers)
    }
}