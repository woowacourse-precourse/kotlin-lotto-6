package model

private const val WINNING_FIFTH_PLACE = "5,000원"
private const val WINNING_FOURTH_PLACE = "50,000원"
private const val WINNING_THIRD_PLACE = "1,500,000원"
private const val WINNING_SECOND_PLACE = "30,000,000원"
private const val WINNING_FIRST_PLACE = "2,000,000,000원"

const val MATCH_THREE_NUMBERS = 3
const val MATCH_FOUR_NUMBERS = 4
const val MATCH_FIVE_NUMBERS = 5
const val MATCH_SIX_NUMBERS = 6

enum class Winning(val lottoWinnings: String, val match: Int = 0) {
    FIFTH_PLACE(lottoWinnings = WINNING_FIFTH_PLACE, match = MATCH_THREE_NUMBERS),
    FOURTH_PLACE(lottoWinnings = WINNING_FOURTH_PLACE, match = MATCH_FOUR_NUMBERS),
    THIRD_PLACE(lottoWinnings = WINNING_THIRD_PLACE, match = MATCH_FIVE_NUMBERS),
    SECOND_PLACE(lottoWinnings = WINNING_SECOND_PLACE, match = MATCH_FIVE_NUMBERS),
    FIRST_PLACE(lottoWinnings = WINNING_FIRST_PLACE, match = MATCH_SIX_NUMBERS);

    override fun toString() =
        if (lottoWinnings != WINNING_SECOND_PLACE) "${match}개 일치 ($lottoWinnings) - "
        else "${match}개 일치, 보너스 볼 일치 ($lottoWinnings) - "
}
