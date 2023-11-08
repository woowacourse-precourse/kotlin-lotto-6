package lotto

enum class LottoPrize(val matchingNumbers: Int, val prizeAmount: Long) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000)
}


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.distinct().size == 6)
        require(numbers.size == 6)
    }


    val winningPoint: MutableMap<LottoPrize, Int> = mutableMapOf(
        LottoPrize.THREE_MATCH to 0,
        LottoPrize.FOUR_MATCH to 0,
        LottoPrize.FIVE_MATCH to 0,
        LottoPrize.FIVE_MATCH_WITH_BONUS to 0,
        LottoPrize.SIX_MATCH to 0
    )

    fun run(autoNumbers: MutableList<List<Int>>, bonusNumber: Int, amount: Int){

        calculateScore(autoNumbers, bonusNumber)
        printWinningPoint()
        countRate(amount)
    }


    fun increaseMatchNumber(key: LottoPrize){
        winningPoint[key] = (winningPoint[key] ?: 0) + 1
    }

    fun calculateScore(autoNumbers: MutableList<List<Int>>, bonusNumber: Int){

        autoNumbers.forEach {
            when(it.intersect(numbers).size) {
                3 -> increaseMatchNumber(LottoPrize.THREE_MATCH)
                4 -> increaseMatchNumber(LottoPrize.THREE_MATCH)
                5 -> if (bonusNumber in it) increaseMatchNumber(LottoPrize.FIVE_MATCH_WITH_BONUS) else increaseMatchNumber(LottoPrize.FIVE_MATCH)
                6 -> increaseMatchNumber(LottoPrize.SIX_MATCH)

            }

        }



    }

    fun printWinningPoint() {
        winningPoint.forEach { prize, count ->
            when (prize) {
                LottoPrize.FIVE_MATCH_WITH_BONUS ->
                    println("${prize.matchingNumbers}개 일치, 보너스 볼 일치 (${"%,d".format(prize.prizeAmount)}원) - ${count}개")
                else ->
                    println("${prize.matchingNumbers}개 일치 (${"%,d".format(prize.prizeAmount)}원) - ${count}개")
            }
        }
    }


    fun countRate(amount: Int){

        var total: Long = 0
        winningPoint.forEach { prize, count -> total += prize.prizeAmount * count }
        println("총 수익률은 ${total.toDouble()/amount*100.0}%입니다.")
    }

}
