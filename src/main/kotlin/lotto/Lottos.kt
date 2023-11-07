package lotto

class Lottos {
    private val UserLotto: MutableList<Lotto> = mutableListOf()

    fun getUserLotto(): List<Lotto> {
        return UserLotto
    }

    fun addUserLotto(lotto: Lotto) {
        UserLotto.add(lotto)
    }

    fun getUserLottoSize(): Int {
        return UserLotto.size
    }
}