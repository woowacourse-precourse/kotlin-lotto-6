package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.PRIZE.*
import java.lang.NumberFormatException

const val PAYMENT_UNIT = 1000
const val PERCENT = 100
fun main() {
    println("구입 금액을 입력해 주세요.")
    var amount = getPayment()

    while (amount == -1) {
        amount = getPayment()
    }

    println("당첨 번호를 입력해 주세요.")
    val lotto = getLotto()

    println("보너스 번호를 입력해 주세요.")
    var bonusNumber:Int
    while(true)
    {
        try {
            bonusNumber = Console.readLine().toInt()
            if(isValidLuckyNumber(bonusNumber,lotto)) throw IllegalArgumentException("[ERROR] 유효하지 않은 보너스 번호입니다.")
        }catch (e:IllegalArgumentException)
        {
            println(e.message)
            continue
        }
        break
    }

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
fun isPaymentValid(amount:Int) = (amount % PAYMENT_UNIT) == 0
fun getNumber():Int
{
    var input:Int
    try {
        input = Console.readLine().toInt()
    }catch (e:NumberFormatException)
    {
        throw IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.")
    }
    return input
}
fun getPayment():Int
{
    var amount:Int
    try {
        amount = getNumber()
        if(!isPaymentValid(amount)) throw IllegalArgumentException("[ERROR]")
    }catch (e:IllegalArgumentException)
    {
        println(e.message)
        return -1
    }
    return amount
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
fun isValidLuckyNumber(bonusNumber:Int,lotto: Lotto) = lotto.contains(bonusNumber) && bonusNumber in 1..45