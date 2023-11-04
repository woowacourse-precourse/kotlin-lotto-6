package lotto.data

enum class GRADE(private val countOfSame: Int, private val isBonusContain: Boolean) {
    ONE(6, false) {
        override fun price() = 2_000_000_000
    },
    TWO(5, true) {
        override fun price() = 30_000_000
    },
    THREE(5, false) {
        override fun price() = 1_500_000
    }, FOUR(4, false) {
        override fun price() = 50_000
    },
    FIVE(3, false) {
        override fun price() = 5_000
    }, LOSE(0, false) {
        override fun price() = 0
    };

    abstract fun price(): Int

    companion object {
        fun from(countOfSame: Int, isBonusContain: Boolean): GRADE {
            return entries.firstOrNull {
                it.countOfSame == countOfSame && it.isBonusContain == isBonusContain
            } ?: LOSE
        }
    }
}