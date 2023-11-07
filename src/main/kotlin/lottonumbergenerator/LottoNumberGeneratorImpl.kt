package lottonumbergenerator

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoNumberGeneratorImpl : LottoNumberGenerator {

    private val _lottoes: MutableList<Lotto> = mutableListOf()
    override val lottoes: List<Lotto>
        get() = _lottoes

    override fun generateLotto(numberOfIssuedLotto: Int) {
        repeat(numberOfIssuedLotto) {
            val randomLottoNumber =
                Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE)
            val sortedRandomLottoNumber = randomLottoNumber.sorted()
            _lottoes.add(Lotto(sortedRandomLottoNumber))
        }
    }

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }
}