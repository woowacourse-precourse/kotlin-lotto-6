package lottonumbergenerator

import lotto.Lotto

interface LottoNumberGenerator {

    val lottoes: List<Lotto>
    fun generateLotto(numberOfIssuedLotto: Int)
}
