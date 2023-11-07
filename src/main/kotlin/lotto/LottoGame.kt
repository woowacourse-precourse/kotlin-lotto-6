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
    companion object{
        private const val CHECK_THREE = "3개 일치 (5,000원)"
        private const val CHECK_FOUR = "4개 일치 (50,000원)"
        private const val CHECK_FIVE = "5개 일치 (1,500,000원)"
        private const val CHECK_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)"
        private const val CHECK_SIX = "6개 일치 (2,000,000,000원)"
        private const val INPUT_PRICE = "구입금액을 입력해 주세요."
        private const val INPUT_BONUS = "보너스 번호를 입력해 주세요."
        private const val INPUT_LOTTO = "당첨 번호를 입력해 주세요."
    }
    fun start(){
        try{
            inputPrice()
            inputPrizeNumber()
            inputBonusNumber()
            for(number in buyNumbers){
                checkLotto(number)
            }
            showResult()
        }catch (e: IllegalArgumentException){
            println(e.message)
        }
    }
    private fun checkLotto(number: List<Int>) {
        var correctNumber = 0
        for(i in number.indices){
            if(number.contains(numbers[i]))  {
                correctNumber++
            }
        }
        if(correctNumber == 5 && number.contains(bonus)){
            Ranking.check(correctNumber,bonus)
        }
        else{
            Ranking.check(correctNumber,0)
        }
    }
    private fun showResult() {
        showText()
        val rank = Ranking.getRank()
        println(CHECK_THREE+ " - ${rank[3]}개")
        println(CHECK_FOUR+ " - ${rank[4]}개")
        println(CHECK_FIVE+ " - ${rank[5]}개")
        println(CHECK_FIVE_BONUS+ " - ${rank[6]}개")
        println(CHECK_SIX+ " - ${rank[7]}개")
        caculate(rank)
        showProfit()
    }
    private fun showProfit() {
        var result = prize.toDouble() / buyPrice.toDouble() * 100.0
        println("총 수익률은 ${String.format("%.1f",result)}%입니다.")
    }
    private fun caculate(rank: IntArray){
        prize = rank[3] * 5000 + rank[4] * 50000 +
                rank[5] *1500000 + rank[6] * 30000000 +
                rank[7]*2000000000
    }
    private fun showText(){
        println("\n당첨 통계")
        println("___")
    }
    private fun inputBonusNumber(){
        println()
        println(INPUT_BONUS)
        val bonusNum = Console.readLine().toInt()
        error.checkBonus(numbers,bonusNum)
        bonus = bonusNum

    }
    private fun inputPrizeNumber(){
        println(INPUT_LOTTO)
        val number = Console.readLine().split(',')
        for(i in number.indices){
            numbers.add(number[i].toInt())
        }
        Lotto(numbers)
    }

    private fun inputPrice(){
        println(INPUT_PRICE)
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