package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class LottoGame {
    private val error = Error()
    private val numbers = mutableListOf<Int>()
    private var buyPrice = 0
    private var bonus = 0
    private var prize = 0
    private val buyNumbers = mutableListOf<List<Int>>()
    private val ranking = IntArray(8)
    fun start(){
        inputPrice()
        inputPrizeNumber()
        inputBonusNumber()
        for(number in buyNumbers){
            checkLotto(number)
        }
        showResult()
    }
    private fun checkLotto(number: List<Int>) {
        var correctNumber = 0
        for(i in number.indices){
            if(number.contains(numbers[i]))  {
                correctNumber++
            }
        }

        if(correctNumber == 3){
            ranking[0]++
            prize += 5000
        }
        if(correctNumber == 4){
            ranking[1]++
            prize += 50000
        }
        if(correctNumber == 5 && !number.contains(bonus)){
            ranking[2]++
            prize += 1500000
        }
        if(correctNumber == 5 && number.contains(bonus)){
            ranking[3]++
            prize += 30000000
        }
        if(correctNumber == 6){
            ranking[4]++
            prize += 2000000000
        }
    }
    private fun showResult() {
        showText()
        println("3개 일치 (5,000원) - ${ranking[0]}개")
        println("4개 일치 (50,000원) - ${ranking[1]}개")
        println("5개 일치 (1,500,000원) - ${ranking[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranking[3]}개")
        println("6개 일치 (2,000,000,000원) - ${ranking[4]}개")
        showProfit()
    }
    private fun showProfit(){
        var result = prize.toDouble() / buyPrice.toDouble() * 100.0
        println("총 수익률은 ${String.format("%.1f",result)}%입니다.")
    }
    private fun showText(){
        println("\n당첨 통계")
        println("___")
    }
    private fun inputBonusNumber(){
        println()
        println("보너스 번호를 입력해 주세요.")
        val bonusNum = Console.readLine().toInt()
        bonus = bonusNum

    }
    private fun inputPrizeNumber(){
        println("당첨 번호를 입력해 주세요.")
        val number = Console.readLine().split(',')
        error.inputNumber(number)
        for(i in number.indices){
            numbers.add(number[i].toInt())
        }
        Lotto(numbers)
    }

    private fun inputPrice(){
        println("구입금액을 입력해 주세요.")
        val price = Console.readLine()
        error.checkPrice(price)
        buyPrice = price.toInt()
        printLotto(price)
    }
    private fun printLotto(price: String) {
        val line = price.toInt()/1000
        println()
        println("${line}개를 구매했습니다.")
        printNumber(line)
    }
    private fun printNumber(line: Int) {
        for(i in 0 until line){
            val numbers : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            println(numbers)
            buyNumbers.add(numbers)
        }
        println()
    }
}