package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_NUMBER_SIZE
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import lotto.utils.Constants.MIN_LOTTO_NUMBER

class Store {
    fun produceLottoNumber(piece: Int): MutableList<Lotto> {
        val newLottoCollection: MutableList<Lotto> = mutableListOf()

        repeat(piece) {
            val newLotto: Lotto = pickLottoNumber()
            newLottoCollection.add(newLotto)
        }

        return newLottoCollection
    }

    private fun pickLottoNumber(): Lotto {
        val newLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)

        return Lotto(newLottoNumbers)
    }
}