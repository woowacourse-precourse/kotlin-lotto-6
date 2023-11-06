package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    private lateinit var lotto: Lotto

    fun get(): Lotto {
        generateLotto()

        return this.lotto
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