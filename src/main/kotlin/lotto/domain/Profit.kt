package lotto.domain

class Profit(val input: Int, val output: Int) {
    var profit: Double = 0.0
    fun computerProfit() {
        val lottoRevenue = (output.toDouble() / input.toDouble()) * 100
        profit = "%.1f".format(lottoRevenue).toDouble()
    }

    fun printProfit(){
        println("총 수익률은 $profit%입니다. ")
    }
}