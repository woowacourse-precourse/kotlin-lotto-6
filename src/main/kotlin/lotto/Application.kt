package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.PRIZE.*

const val PAYMENT_UNIT = 1000

fun main() {
    println("구입 금액을 입력해 주세요.")
    var amount = getPayment()

    while (amount != -1) {
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
            continue
        }
        break
    }

    val myLottos = mutableListOf<Lotto>()
    repeat(amount / PAYMENT_UNIT)
    {
        myLottos.add(getLotto())
    }
    println("${amount / PAYMENT_UNIT}를 구매 했습니다.")
    myLottos.forEach{
        println(it)
    }

    println("당첨 통계")
    println("---")
    val result = lotto.getResult(myLottos,bonusNumber)
    printPrize(result)

    printProfit(result,amount)
}
fun isPaymentValid(amount:Int) = (amount % PAYMENT_UNIT) == 0
fun getPayment():Int
{
    var amount:Int
    try {
        amount = Console.readLine().toInt()
        if(!isPaymentValid(amount)) throw IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.")
    }catch (e:IllegalArgumentException)
    {
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
        FIFTH -> return "5000"
        FOURTH -> return "50,000"
        THIRD -> return "1,500,000"
        SECOND -> return "30,000,000"
        FIRST -> return "2,000,000,000"
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
fun getRank(prize: PRIZE):Int
{
    when(prize)
    {
        FIFTH -> return 3
        FOURTH -> return 4
        THIRD -> return 5
        SECOND -> return 5
        FIRST -> return 6
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
    println("총 수익률은 ${String.format("%.2f",profit.toFloat()/invest)}")
}
fun printPrize(result:Map<PRIZE,Int>)
{
    val keys = result.keys.sorted()
    for(key in keys)
    {
        println("${getRank(key)}개 일치 (${getStringMoney(key)}) - ${result[key]}개 ")
    }
}
fun isValidLuckyNumber(bonusNumber:Int,lotto: Lotto) = lotto.contains(bonusNumber) && bonusNumber in 1..45