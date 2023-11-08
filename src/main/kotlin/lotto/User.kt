package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
class User {
    val ticket = mutableListOf<List<Int>>()
    fun buyLotto(): Int {
        var input = readLine()
        if (input!!.toInt() % ONE_PRICE_LOTTO != 0) throw IllegalArgumentException("${ERROR_MESSAGE}구매 가격은 1000으로 나누어 떨어져야 합니다")
        return input.toInt()
    }

    fun buyLottoCount(money : Int): Int{
        var count = money / ONE_PRICE_LOTTO

        println("${count}개를 구매했습니다.")
        return count
    }
    fun saveTicket(count: Int){
        for(i in 1..count){
            ticket.add(numbers())
        }
    }
    fun printTicket(): MutableList<List<Int>> {
        ticket.forEach { println(it) }
        return ticket
    }

    fun numbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, HOW_MANY_NUMBER).sorted()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val HOW_MANY_NUMBER = 6
        const val ONE_PRICE_LOTTO = 1000
        const val ERROR_MESSAGE = "[ERROR]"
    }
}
