package lotto.model

import lotto.util.Constant.UNIT_PRICE

class User {

    private val _lottoes: MutableList<Lotto> = mutableListOf()
    val lottoes : List<Lotto> get() = _lottoes

    private var _price = 0
    val price get() = _price

    fun setPrice(price: Int){
        _price = price
    }
    fun buyLotto() {
        repeat(_price / UNIT_PRICE) {
            _lottoes.add(Lotto(LottoNumberGenerator.makeLottoNumber()))
        }
    }
}