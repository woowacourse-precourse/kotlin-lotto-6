package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private val error = Error()
    private val numbers = mutableListOf<Int>()
    private var bonus = 0
    fun start(){
        inputPrice()
        inputPrizeNumber()
        inputBonusNumber()
    }
    private fun inputBonusNumber(){
        val bonusNum = Console.readLine().toInt()
        bonus = bonusNum

    }
    private fun inputPrizeNumber(){
        println("당첨 번호를 입력해 주세요.")
        val number = Console.readLine().split(',')
        for(i in number.indices){
            numbers.add(number[i].toInt())
        }
        Lotto(numbers)
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
        printNumber(line)
    }
    private fun printNumber(line: Int) {
        for(i in 0 until line){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            println(numbers)
        }
        println()
    }
}