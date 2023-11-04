package lotto.model

class Profit {
    fun calculateProfit(money: Int,jackpot: List<Int>):Float{
        var profit = 0
        profit += jackpot[0] * Constants.FIVE_THOUSAND
        profit += jackpot[1] * Constants.FIFTY_THOUSAND
        profit += jackpot[2] * Constants.ONE_MILLION_FIVE_HUNDRED_THOUSAND
        profit += jackpot[3] * Constants.THIRTY_MILLION
        profit += jackpot[4] * Constants.TWO_BILLION

        return profit/money.toFloat()*Constants.HUNDRED
    }
}