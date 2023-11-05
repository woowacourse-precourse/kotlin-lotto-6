package lotto.domain.model

import lotto.Lotto
import lotto.domain.service.LottoService

class Customer {
    val lotteries = mutableListOf<Lotto>()

    fun buyLotteries(price:Int){
        val lottoService = LottoService()
        repeat(price / 1000){
            lotteries.add(lottoService.createLotto())
        }
    }

}