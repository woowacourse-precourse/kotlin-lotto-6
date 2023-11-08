package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.PRIZE.*


fun main() {
    println("구입 금액을 입력해 주세요.")
    var amount = getAmount()

    println("당첨 번호를 입력해 주세요.")
    val lotto = getLotto()

    println("보너스 번호를 입력해 주세요.")
    var bonusNumber = getBonusNumber(lotto)

    val myLottos = mutableListOf<Lotto>()
    repeat(amount / PAYMENT_UNIT)
    {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        myLottos.add(generateLotto(numbers))
    }

    println("${amount / PAYMENT_UNIT}개를 구매했습니다.")
    myLottos.forEach{
        println(it)
    }

    println("당첨 통계")
    println("---")
    val result = lotto.getResult(myLottos,bonusNumber)
    printPrize(result)

    printProfit(result,amount)
}
fun generateLotto(numbers:List<Int>):Lotto
{
    var lotto:Lotto
    while(true)
    {
        try {
            lotto = Lotto(numbers)
        }catch (e:IllegalArgumentException)
        {
            println(e.message)
            continue
        }
        break
    }
    return lotto
}



fun getLotto(): Lotto {
    var lotto:Lotto
    while(true)
    {
        try {
            lotto = Lotto(Console.readLine()
                .split(",")
                .map { it.toInt() })
        }catch (e:IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    }
    return lotto
}
fun getStringMoney(prize: PRIZE):String
{
    when(prize)
    {
        FIFTH -> return "3개 일치 (5,000원)"
        FOURTH -> return "4개 일치 (50,000원)"
        THIRD -> return "5개 일치 (1,500,000원)"
        SECOND -> return "5개 일치, 보너스 볼 일치 (30,000,000원)"
        FIRST -> return "6개 일치 (2,000,000,000원)"
        NONE-> return "0"
    }
}
fun getIntMoney(prize: PRIZE):Int
{
    when(prize)
    {
        FIFTH -> return 5000
        FOURTH -> return 50000
        THIRD -> return 1500000
        SECOND -> return 30000000
        FIRST -> return 2000000000
        NONE-> return 0
    }
}

fun printProfit(result: Map<PRIZE, Int>,invest:Int)
{
    val keys = result.keys.sorted()
    var profit = 0
    for(key in keys)
    {
        profit += getIntMoney(key) * result.getOrDefault(key,0)
    }
    println("총 수익률은 ${String.format("%.1f%%",profit.toFloat()/invest * PERCENT)}입니다.")
}
fun printPrize(result:Map<PRIZE,Int>)
{
    val keys = result.keys.sortedByDescending { it }
    for(key in keys)
    {
        println("${getStringMoney(key)} - ${result[key]}개 ")
    }
}
