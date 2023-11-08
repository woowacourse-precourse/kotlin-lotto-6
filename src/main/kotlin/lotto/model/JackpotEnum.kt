package lotto.model

enum class Rank(val label: String, val count: Int, val countLabel: String) {
    THIRD(Constants.THREE_SAME, 0, Constants.COUNT),
    FOURTH(Constants.FOUR_SAME, 0, Constants.COUNT),
    FIFTH(Constants.FIVE_SAME, 0, Constants.COUNT),
    FIFTH_WITH_BONUS(Constants.FIVE_WITH_BONUS_SAME, 0, Constants.COUNT),
    SIXTH(Constants.SIX_SAME, 0, Constants.COUNT);
}