package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

class LottoGenerator {
    private lateinit var lotto: Lotto

    fun get(): Lotto {
        validateLotto()

        return this.lotto
    }

    private fun validateLotto() {
        try {
            generateLotto()
        } catch (e: IllegalArgumentException) { }
    }

    private fun generateLotto() {
        val lottoNumbers = mutableSetOf<Int>()

        while (lottoNumbers.size != Constants.LOTTO_NUMBER_COUNT) {
            lottoNumbers.add(generatedLottoNumber())
        }

        this.lotto = Lotto(lottoNumbers.toList())
    }

    private fun generatedLottoNumber(): Int {
        return Randoms.pickNumberInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER)
    }
}