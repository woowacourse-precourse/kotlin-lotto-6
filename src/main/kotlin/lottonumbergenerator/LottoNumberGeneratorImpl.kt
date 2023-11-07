package lottonumbergenerator

import camp.nextstep.edu.missionutils.Randoms
import entity.LottoNumber

class LottoNumberGeneratorImpl : LottoNumberGenerator {

    private val _lottoes: MutableList<LottoNumber> = mutableListOf()
    override val lottoes: List<LottoNumber>
        get() = _lottoes

    override fun generateLotto(numberOfIssuedLotto: Int) {
        repeat(numberOfIssuedLotto) {
            val randomLottoNumber =
                Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE)
            val sortedRandomLottoNumber = randomLottoNumber.sorted()
            _lottoes.add(LottoNumber(sortedRandomLottoNumber))
        }
    }

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }
}