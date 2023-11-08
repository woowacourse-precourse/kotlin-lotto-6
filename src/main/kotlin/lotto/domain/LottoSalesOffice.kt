package lotto.domain

class LottoSalesOffice (money : String) {

    fun sellLotto (money : String) {
        val quantity = money.toInt()/1000
        val lottos = mutableListOf<Lotto>()

        repeat(quantity){
            val lotto = RandomGenerator().generate()
            lottos.add(lotto)
        }
    }

    companion object {
        private const val SINGLE_LOTTO_PRICE = 1000
    }

}