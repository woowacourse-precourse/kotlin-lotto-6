package lotto.ui

import lotto.data.ConstNum
import lotto.data.ConstString
import lotto.domain.Customer

class LottoCustomerScreen(lottoCounts : Int, lottoNumsList : List<List<Int>>) {

    private var lottoCounts = 0
    private var lottoNumsList = emptyList<List<Int>>()

    init {

        this.lottoCounts = lottoCounts
        this.lottoNumsList = lottoNumsList

    }


    fun printLottoNumsList(){

        println(ConstString.LOTTO_COUNTS_MESSAGE.format(lottoCounts))
     //   println("${lottoCounts}개를 구매했습니다.")
        lottoNumsList.forEach {
                nums ->
            println(nums)
        }

    }


}