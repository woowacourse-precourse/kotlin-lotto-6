package lotto.data

import java.text.DecimalFormat

enum class GRADE(val countOfSame: Int, private val isBonusContain: Boolean) {
    ONE(6, false) {
        override fun price() = 2_000_000_000
        override fun priceAsString() = "${priceFormat.format(ONE.price())}$KIND_OF_CURRENCY_KR"
        override fun rank() = RANK.FIRST
    },
    TWO(5, true) {
        override fun price() = 30_000_000
        override fun priceAsString() = "${priceFormat.format(TWO.price())}$KIND_OF_CURRENCY_KR"
        override fun rank() = RANK.SECOND
    },
    THREE(5, false) {
        override fun price() = 1_500_000
        override fun priceAsString() = "${priceFormat.format(THREE.price())}$KIND_OF_CURRENCY_KR"
        override fun rank() = RANK.THIRD
    },
    FOUR(4, false) {
        override fun price() = 50_000
        override fun priceAsString() = "${priceFormat.format(FOUR.price())}$KIND_OF_CURRENCY_KR"
        override fun rank() = RANK.FOURTH
    },
    FIVE(3, false) {
        override fun price() = 5_000
        override fun priceAsString() = "${priceFormat.format(FIVE.price())}$KIND_OF_CURRENCY_KR"
        override fun rank() = RANK.FIFTH
    },
    LOSE(0, false) {
        override fun price() = 0
        override fun priceAsString() = "${priceFormat.format(LOSE.price())}$KIND_OF_CURRENCY_KR"
        override fun rank() = RANK.NONE
    };

    abstract fun price(): Int
    abstract fun priceAsString(): String
    abstract fun rank(): RANK

    companion object {
        const val KIND_OF_CURRENCY_KR = "원"
        private val priceFormat = DecimalFormat("#,###")

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