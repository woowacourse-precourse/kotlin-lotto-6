package lotto

enum class LottoPrize(val value: Int, var count: Int, val prizeMoney: Long) {
    FIFTH_PRIZE(3, 0, 5_000) {
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_FIFTH_PRIZE}) - ${count}개")
    },
    FOURTH_PRIZE(4, 0, 50_000) {
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_FOURTH_PRIZE}) - ${count}개")
    },
    THIRD_PRIZE(5, 0, 1_500_000) {
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_THIRD_PRIZE}) - ${count}개")
    },
    SECOND_PRIZE(5, 0, 30_000_000) {
        override fun printPrizeData() =
            println("${value}개 일치, 보너스 볼 일치 (${MONEY_SECOND_PRIZE}) - ${count}개")
    },
    JACKPOT(6, 0, 2_000_000_000) {
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_JACKPOT}) - ${count}개")
    };

    abstract fun printPrizeData()

    fun calculatePrizeMoney(): Long = count * prizeMoney

    companion object {
        const val MONEY_JACKPOT = "2,000,000,000원"
        const val MONEY_SECOND_PRIZE = "30,000,000원"
        const val MONEY_THIRD_PRIZE = "1,500,000원"
        const val MONEY_FOURTH_PRIZE = "50,000원"
        const val MONEY_FIFTH_PRIZE = "5,000원"
    }
}