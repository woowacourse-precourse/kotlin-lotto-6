package lotto.ui

import lotto.domain.Customer
import lotto.domain.LottoManager

class LottoScreen {

    private var lottoCounts = 0
    private var lottoNumsList = emptyList<List<Int>>()

    init {
        val customer = Customer()
        val lottoManager = LottoManager()

        lottoCounts = customer.getPurchaseCounts()
        lottoNumsList = customer.lottoNumsList


    }


    fun printLottoNumsList(){

        println("${lottoCounts}개를 구매했습니다")
        lottoNumsList.forEach {
                nums ->
            println(nums)
        }

    }


}