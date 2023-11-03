package lotto

import camp.nextstep.edu.missionutils.Randoms

enum class MatchCount {
    NONE,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    FIVEBONUS,
    ALL
}


fun main() {
    println("구입금액을 입력해 주세요")

    val numoflotto = moneycheck()

    val mynumber = mutableListOf<List<Int>>()
    val match = mutableListOf<MatchCount>()
    println("${numoflotto}개를 구매했습니다.")

    for (i in 0 until numoflotto)
    {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        mynumber.add(numbers)
        Lotto(numbers).printnumbers()
    }
    println("당첨 번호를 입력해 주세요.")
    val winningnumber = winningnumbercheck()

    println("보너스 번호를 입력해 주세요.")
    val bonus = bonuscheck()

    for (i in 0 until numoflotto)
    {
        match.add(Lotto(mynumber[i]).checklotto(winningnumber, bonus))
    }

    printtotal(match, numoflotto*1000)
}

fun moneycheck(): Int {
    while (true)
    {
        try {
            val input = readlnOrNull()
            if (input != null)
            {
                val money = input.toInt()
                val price = 1000
                val numoflotto = money.div(price)
                if(money.rem(price) != 0){
                    throw IllegalArgumentException("[Error] 1,000원으로 나누어 떨어지지 않습니다.")
                }
                return numoflotto
            }
            else {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException)
        {
            println("[Error] 정수가 아닙니다.")
        }

    }
}

fun winningnumbercheck(): List<Int> {
    while (true)
    {
        try {
            val input = readlnOrNull()
            if (input != null) {
                return input.split(",").map { it.toInt() }
            }
            else {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException)
        {
            println("[Error] 정수가 아닙니다.")
        }

    }
}

fun bonuscheck(): Int {
    while (true)
    {
        try {
            val input = readlnOrNull()
            if (input != null) {
                return input.toInt()
            }
            else {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException)
        {
            println("[Error] 정수가 아닙니다.")
        }

    }
}

fun printtotal(matchnum: List<MatchCount>, money: Int) {
    println("당첨 통계")
    println("---")
    val three = matchnum.count{it == MatchCount.THREE}
    val four = matchnum.count{it == MatchCount.FOUR}
    val five = matchnum.count{it == MatchCount.FIVE}
    val bonus = matchnum.count{it == MatchCount.FIVEBONUS}
    val all = matchnum.count{it == MatchCount.ALL}

    println("3개 일치 (5,000원) - ${three}개")
    println("4개 일치 (50,000원) - ${four}개")
    println("5개 일치 (1,500,000원) - ${five}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${bonus}개")
    println("6개 일치 (2,000,000,000원) - ${all}개")
    yeildcalculation(three,four,five,bonus,all, money)
}
fun yeildcalculation(three: Int, four: Int, five: Int, bonus: Int, all: Int, money: Int)
{
    val totalmoney = three * 5000 + four * 50000 + five * 1500000 + bonus * 30000000 + all * 2000000000
    val result = totalmoney / money * 100
    val formattedresult = String.format("%.2f", result)
    println("총 수익률은 $formattedresult")
}