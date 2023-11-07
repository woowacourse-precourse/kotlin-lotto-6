package lotto.ui

import lotto.domain.Customer

class LottoScreen {

    private var lottoCounts = 0
    private var lottoNumsList = emptyList<List<Int>>()

    init {
        val customer = Customer()

        lottoCounts = customer.getPurchaseCounts()
        lottoNumsList = customer.lottoNumsList

        println("${lottoCounts}개를 구매했습니다")
        lottoNumsList.forEach {
            nums ->
            println(nums)
        }

    }


}