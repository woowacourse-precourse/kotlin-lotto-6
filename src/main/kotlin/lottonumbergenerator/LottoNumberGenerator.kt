package lottonumbergenerator

import entity.LottoNumber

interface LottoNumberGenerator {

    val lottoes: List<LottoNumber>
    fun generateLotto(numberOfIssuedLotto: Int)
}
