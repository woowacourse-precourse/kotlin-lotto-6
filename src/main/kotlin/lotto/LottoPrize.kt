package lotto

enum class LottoPrize(val matchedNumbers: Int, val matchedBonus: Boolean, val prize: Int, var jackpot: Int) {
    MATCHED3(3, false, 5000, 0),
    MATCHED4(4, false, 50000, 0),
    MATCHED5(5, false, 1500000, 0),
    MATCHED5_AND_BONUS(5, true, 3000000, 0),
    MATCHED6(6, false, 2000000000, 0);

    fun incrementCount() {
        jackpot++
    }
}