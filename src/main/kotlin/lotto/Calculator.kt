package lotto

class Calculator() {
    fun calculateRateReturn(rank: List<Int>, money: Int): String {

        val returnMoney = (PriceHowManyMatch.일치3개.priceReturn() * rank[0]
                + PriceHowManyMatch.일치4개.priceReturn() * rank[1]
                + PriceHowManyMatch.일치5개.priceReturn() * rank[2]
                + PriceHowManyMatch.일치5개보너스.priceReturn() * rank[3]
                + PriceHowManyMatch.일치6개.priceReturn() * rank[4])

        return String.format("%.1f", returnMoney * 100.0 / money)
    }

//    fun compareCountingMatchedWinningNumber(lotto: Lotto, winningNumber: Lotto): Int {
//        return (lotto.numbers.toSet().intersect(winningNumber.toSet()).size)
//    }
//
//    fun compareCountingMatchedBonusNumber(lotto: Lotto, bonusNumber: List<Int>): Boolean {
//        return numbers.toSet().intersect(bonusNumber.bonusNumber.toSet()).size == 1
//    }
//
//    fun divideStandard1to6(win: Int, bonus: Boolean): Int {
//
//        val checkValue = listOf(win, bonus)
//
//        return when (checkValue) {
//            listOf(3, false) -> 0
//            listOf(3, true) -> 0
//            listOf(3, false) -> 1
//            listOf(4, true) -> 1
//            listOf(5, false) -> 2
//            listOf(5, true) -> 3
//            listOf(6, false) -> 4
//            else -> 5
//        }
//    }

}

enum class PriceHowManyMatch(private val price: Int) {
    일치3개(5000),
    일치4개(50000),
    일치5개(1500000),
    일치5개보너스(30000000),
    일치6개(2000000000);

    fun priceReturn() = price
}