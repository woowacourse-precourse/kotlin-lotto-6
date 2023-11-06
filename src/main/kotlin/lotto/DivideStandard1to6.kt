package lotto

enum class DivideStandard1to6(
    val rank: String
) {
    ONE("1등") {
        override fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int {
            TODO("Not yet implemented")
        }
    },
    TWO("2등") {
        override fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int {
            TODO("Not yet implemented")
        }
    },
    THREE("3등") {
        override fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int {
            TODO("Not yet implemented")
        }
    },
    FOUR("4등") {
        override fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int {
            TODO("Not yet implemented")
        }
    },
    FIVE("5등") {
        override fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int {
            TODO("Not yet implemented")
        }
    },
    SIX("6등") {
        override fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int {
            TODO("Not yet implemented")
        }
    };

    abstract fun calculateWinningAmount(matchedWinning: Int, matchedBonus: Boolean): Int
}