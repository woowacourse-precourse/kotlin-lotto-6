package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
class User {
    fun buyLotto(): Int {
        var input = readLine()!!.toInt()
        if (input % ONE_PRICE_LOTTO != 0) throw IllegalArgumentException("[ERROR]")
        return input
    }
    fun buyLottoCount(money : Int): Int{
        var count = money % ONE_PRICE_LOTTO

        println("${count}개를 구매했습니다.")
        return count
    }
    fun Numbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, HOW_MANY_NUMBER).sorted()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val HOW_MANY_NUMBER = 6
        const val ONE_PRICE_LOTTO = 1000
    }
}

//if (input !in MIN_NUMBER..MAX_NUMBER) throw IllegalArgumentException("[ERROR]")