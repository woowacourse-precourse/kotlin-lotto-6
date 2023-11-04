package lotto

object LottoGenerator {

    internal fun createByMoney(money: Int): MutableList<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()
        val count = moneyToCount(money)
        for (i in 1..count) lottos.add(Lotto())

        return lottos
    }

    private fun moneyToCount(money: Int): Int {
        require(money >= 1000 &&
            money % 1000 == 0)

        return money / 1000
    }

}