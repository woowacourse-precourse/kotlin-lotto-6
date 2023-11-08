package lotto.data

enum class GRADE(val countOfSame: Int, private val isBonusContain: Boolean) {
    ONE(6, false) {
        override fun price() = 2_000_000_000
        override fun priceAsString() = "2,000,000,000원"
        override fun rank() = RANK.FIRST
    },
    TWO(5, true) {
        override fun price() = 30_000_000
        override fun priceAsString() = "30,000,000원"
        override fun rank() = RANK.SECOND
    },
    THREE(5, false) {
        override fun price() = 1_500_000
        override fun priceAsString() = "1,500,000원"
        override fun rank() = RANK.THIRD
    },
    FOUR(4, false) {
        override fun price() = 50_000
        override fun priceAsString() = "50,000원"
        override fun rank() = RANK.FOURTH
    },
    FIVE(3, false) {
        override fun price() = 5_000
        override fun priceAsString() = "5,000원"
        override fun rank() = RANK.FIFTH
    },
    LOSE(0, false) {
        override fun price() = 0
        override fun priceAsString() = "0원"
        override fun rank() = RANK.NONE
    };

    abstract fun price(): Int
    abstract fun priceAsString(): String
    abstract fun rank(): RANK

    companion object {
        fun from(countOfSame: Int, isBonusContain: Boolean): GRADE {
            return entries.firstOrNull {
                it.countOfSame == countOfSame && it.isBonusContain == isBonusContain
            } ?: LOSE
        }

        fun from(rank: Int): GRADE {
            return entries.firstOrNull {
                it.rank().index == rank
            } ?: LOSE
        }
    }
}