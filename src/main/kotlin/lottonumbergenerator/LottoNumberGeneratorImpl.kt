package lottonumbergenerator

import entity.LottoNumber

class LottoNumberGeneratorImpl : LottoNumberGenerator {

    private val _lottoes: MutableList<LottoNumber> = mutableListOf()
    override val lottoes: List<LottoNumber>
        get() = _lottoes

    override fun generateLotto(numberOfIssuedLotto: Int) {
        TODO("Not yet implemented")
    }
}
