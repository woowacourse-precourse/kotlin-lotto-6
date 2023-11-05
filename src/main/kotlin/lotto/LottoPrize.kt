package lotto

enum class LottoPrize(val matchedNumbers: Int, val matchedBonus: Boolean, val prize: Int, var count: Int) {
    MATCHED3(3, false, 5000, 0),
    MATCHED4(4, false, 50000, 0),
    MATCHED5(5, false, 1500000, 0),
    MATCHED5_AND_BONUS(5, true, 3000000, 0),
    MATCHED6(6, false, 2000000000, 0);

    fun getMatchedNumbers(): Int {
        return matchedNumbers
    }

    fun getMatchedBonus(): Boolean {
        return matchedBonus
    }

    fun getPrize(): Int {
        return prize
    }

    fun getCount(): Int {
        return count
    }

    fun incrementCount() {
        count++
    }
}