package lotto.model

import lotto.isInRange

@JvmInline
value class Rank(private val value: Int) {

    val prize: Long get() = Prize.get(this)?.money ?: 0

    init {
        validateInRange()
    }

    private fun validateInRange() {
        require(value.isInRange(FIRST_RANK, LAST_RANK)) { OUT_OF_RANGE_ERROR }
    }

    companion object {
        private const val FIRST_RANK = 1
        private const val LAST_RANK = 5
        internal const val OUT_OF_RANGE_ERROR = "잘못된 등수 값을 입력했습니다. 로또의 등수는 ${FIRST_RANK}~${LAST_RANK}까지만 존재합니다."

        val listAllRanks: List<Rank> = (FIRST_RANK..LAST_RANK).map { Rank(it) }

        fun of(matchingCount: Int, isMatchedBonus: Boolean): Rank? =
            when (matchingCount) {
                6 -> Rank(1)
                5 -> if (isMatchedBonus) Rank(2) else Rank(3)
                4 -> Rank(4)
                3 -> Rank(5)
                else -> null
            }
    }

    internal enum class Prize(val money: Long, val rank: Int) {
        First(2_000_000_000, 1),
        Second(30_000_000, 2),
        Third(1_500_000, 3),
        Fourth(50_000, 4),
        Fifth(5_000, 5);

        companion object {
            fun get(rank: Rank): Prize? = entries.find { prize -> rank.value == prize.rank }
        }
    }
}