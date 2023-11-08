package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Controller {
    fun getSeedMoney(): Int {
        println(Utils.GET_SEED_MONEY_MESSAGE)
        val seedMoney = Console.readLine()
        return seedMoney.toInt()
    }

    fun generateLottoNumbers(seedMoney: Int): Int {
        val ticketNumber = seedMoney / 1000
        println("${ticketNumber}+${Utils.NUMBER_OF_TICKETS_MESSAGE}")
        return ticketNumber
    }

    fun getRandomLottoNumbers(ticketNumber: Int): List<List<Int>> {
        var lottoNumberResults : MutableList<List<Int>> = mutableListOf()
        repeat(ticketNumber) {
            var lottoNumbers = Randoms.pickUniqueNumbersInRange(Utils.MIN_NUMBER, Utils.MAX_NUMBER, Utils.LOTTO_NUMBER_SIZE).toList()
            lottoNumberResults.add(lottoNumbers.sorted())
        }
        return lottoNumberResults
    }

    fun printRandomLottoNumbers(lottoNumberResults: List<List<Int>>) {
        for(lottoNumbers in lottoNumberResults)
            println("[${lottoNumbers.joinToString(", ")}]")
    }


    fun getRealLottoNumbers(): List<Int> {
        println(Utils.GET_REAL_LOTTO_NUMBER_MESSAGE)

        val realLottoNumberString = Console.readLine()
        val realLottoNumbers = realLottoNumberString.replace(" ", "").split(",")

        return realLottoNumbers.map { it.toInt() }
    }

    fun getBonusLottoNumber(): Int {
        println(Utils.GET_BONUS_LOTTO_NUMBER_MESSAGE)

        val bonusLottoNumber = Console.readLine()

        return bonusLottoNumber.toInt()
    }
}