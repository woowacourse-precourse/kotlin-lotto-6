package lotto

class LottoGenerator(var money: Int = 0) {

    init {
        require(
            money >= 1000 &&
            money % 1000 == 0
        )
    }

    fun create(): MutableList<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()
        for (i in 1..moneyToCount()) lottos.add(Lotto())

        return lottos
    }

    private fun moneyToCount() = money / 1000
}