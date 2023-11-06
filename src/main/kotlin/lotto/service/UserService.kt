package lotto.service

import lotto.domain.Lotto
import lotto.domain.User
import lotto.util.Constant.UNIT_PRICE

class UserService() {

    private val lottoes: MutableList<Lotto> = mutableListOf()


    fun makeUser(price : Int): User {
        buyLotto(price)
        return User(price, lottoes)
    }

    private fun buyLotto(price : Int) {
        repeat(price / UNIT_PRICE) {
            lottoes.add(Lotto(LottoService.makeLottoNumber()))
        }
    }

}