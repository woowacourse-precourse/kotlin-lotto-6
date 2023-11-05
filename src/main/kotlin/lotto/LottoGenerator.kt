package lotto

object LottoGenerator {

    fun createByMoney(money: Int): MutableList<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()
        for (i in 1..moneyToCount(money)) lottos.add(Lotto())

        return lottos
    }

    private fun moneyToCount(money: Int): Int {
        require(money >= 1000 &&
            money % 1000 == 0)

        return money / 1000
    }
}