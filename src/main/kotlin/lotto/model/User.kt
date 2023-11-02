package lotto.model

import lotto.util.Constant.UNIT_PRICE

class User {

    private val _lottoes: MutableList<Lotto> = mutableListOf()
    val lottoes : List<Lotto> get() = _lottoes
    fun buyLotto(price: Int) {
        repeat(price / UNIT_PRICE) {
            _lottoes.add(Lotto(LottoNumberGenerator.makeLottoNumber()))
        }
    }
}