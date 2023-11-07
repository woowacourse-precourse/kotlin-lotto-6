package lotto.domain

import lotto.util.applyPriceFormat

enum class LottoResult(val count: Int, val prize: Double) {
    THREE_MATCH(3, 5000.0),
    FOUR_MATCH(4, 50000.0),
    FIVE_MATCH(5, 1500000.0) {
        override fun isSame(matchCount: Int, matchBonus: Boolean): Boolean {
            return super.isSame(matchCount, matchBonus) && !matchBonus
        }
    },
    FIVE_WITH_BONUS_MATCH(5, 30000000.0) {
        override fun toMessage(): String {
            return "${count}개 일치, 보너스 볼 일치 (${applyPriceFormat(prize.toInt())}) - "
        }
    },
    SIX_MATCH(6, 2000000000.0),
    NONE(0, 0.0);

    open fun isSame(matchCount: Int, matchBonus: Boolean): Boolean = this.count == matchCount

    open fun toMessage(): String = "${count}개 일치 (${applyPriceFormat(prize.toInt())}) - "

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): LottoResult {
            return values().find {
                it.isSame(matchCount, matchBonus)
            } ?: NONE
        }
    }
}