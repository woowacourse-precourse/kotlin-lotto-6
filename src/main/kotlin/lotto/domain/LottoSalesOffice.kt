package lotto.domain

import lotto.validator.Validator

class LottoSalesOffice {

    fun sellLotto (money : Int) : List<Lotto> {
        Validator(money)
        val quantity = money/1000
        val lottos = mutableListOf<Lotto>()

        repeat(quantity){
            val lotto = RandomGenerator().generate()
            lottos.add(lotto)
        }

        return lottos
    }



    companion object {
        private const val SINGLE_LOTTO_PRICE = 1000
    }

}