package lotto.domain

enum class WinningModel(val matches: Int, val prize: Long, val withBonus: Boolean = false) {
    NONE(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000, withBonus = true),
    SIX_MATCH(6, 2000000000);

    companion object {
        fun fromMatches(matches: Int, bonusMatch: Boolean): WinningModel {
            return values().firstOrNull {
                it.matches == matches && (!it.withBonus || bonusMatch)
            } ?: NONE
        }
    }
}
