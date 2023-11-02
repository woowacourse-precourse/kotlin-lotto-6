package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private val error = Error()
    fun start(){
        inputPrice()
        inputPrizeNumber()
    }
    private fun inputPrizeNumber(){

    }

    private fun inputPrice(){
        println("구입금액을 입력해 주세요.")
        val price = Console.readLine().toInt()
        error.checkPrice(price)
        printLotto(price)
    }
    private fun printLotto(price: Int) {
        val line = price/1000
        println()
        println("${line}개를 구매했습니다.")
    }

}