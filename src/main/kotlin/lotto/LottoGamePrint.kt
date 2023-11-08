package lotto

fun printMyLottos(lottos:List<Lotto>) = lottos.forEach {
    println(it)
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
    println("당첨 통계")
    println("---")
    val keys = result.keys.sortedByDescending { it }
    for(key in keys)
    {
        println("${getStringMoney(key)} - ${result[key]}개 ")
    }
}