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
    val money = readlnOrNull()
    val price = 1000
    val numoflotto = money?.toInt()?.div(price)
    val mynumber = mutableListOf<List<Int>>()
    val match = mutableListOf<MatchCount>()

    for (i in 0 until numoflotto!!)
    {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        mynumber.add(numbers)
        Lotto(numbers).printnumbers()
    }
    println("당첨 번호를 입력해 주세요.")
    val inputwinningnumber = readlnOrNull()
    val winningnumber = inputwinningnumber?.split(",")?.map { it.toInt() }

    println("보너스 번호를 입력해 주세요.")
    val bonus = readlnOrNull()?.toInt()

    for (i in 0 until numoflotto)
    {
        match.add(Lotto(mynumber[i]).checklotto(winningnumber, bonus))
    }

    printtotal(match, money.toInt())
}

fun printtotal(matchnum: List<MatchCount>, money: Int) {
    println("당첨 통계")
    println("---")
    val three = matchnum.count{it == MatchCount.THREE}
    val four = matchnum.count{it == MatchCount.FOUR}
    val five = matchnum.count{it == MatchCount.FIVE}
    val bonus = matchnum.count{it == MatchCount.FIVEBONUS}
    val all = matchnum.count{it == MatchCount.ALL}

    println("3개 일치 (5,000원) - $three 개")
    println("4개 일치 (50,000원) - $four 개")
    println("5개 일치 (1,500,000원) - $five 개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - $bonus 개")
    println("6개 일치 (2,000,000,000원) - $all 개")
}
fun yeildcalculation(three: Int, four: Int, five: Int, bonus: Int, all: Int, money: Int)
{
    val totalmoney = three * 5000 + four * 50000 + five * 1500000 + bonus * 30000000 + all * 2000000000
    val result = totalmoney / money * 100
    val formattedresult = String.format("%.2f", result)
    println("총 수익률은 $result")
}