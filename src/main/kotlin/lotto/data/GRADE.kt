package lotto.data

enum class GRADE(val countOfSame: Int, private val isBonusContain: Boolean) {
    ONE(6, false) {
        override fun price() = 2_000_000_000
        override fun priceAsString() = "2,000,000,000원"
        override fun rank() = 1
    },
    TWO(5, true) {
        override fun price() = 30_000_000
        override fun priceAsString() = "30,000,000원"
        override fun rank() = 2
    },
    THREE(5, false) {
        override fun price() = 1_500_000
        override fun priceAsString() = "1,500,000원"
        override fun rank() = 3
    },
    FOUR(4, false) {
        override fun price() = 50_000
        override fun priceAsString() = "50,000원"
        override fun rank() = 4
    },
    FIVE(3, false) {
        override fun price() = 5_000
        override fun priceAsString() = "5,000원"
        override fun rank() = 5
    },
    LOSE(0, false) {
        override fun price() = 0
        override fun priceAsString() = "0원"
        override fun rank() = 0
    };

    abstract fun price(): Int
    abstract fun priceAsString(): String
    abstract fun rank(): Int

    companion object {
        fun from(countOfSame: Int, isBonusContain: Boolean): GRADE {
            return entries.firstOrNull {
                it.countOfSame == countOfSame && it.isBonusContain == isBonusContain
            } ?: LOSE
        }

        fun fromRank(rank: Int): GRADE {
            return entries.firstOrNull {
                it.rank() == rank
            } ?: LOSE
        }
    }
}