package lotto.data

import lotto.resources.Lotto.MATCH_FIVE_PRISE
import lotto.resources.Lotto.MATCH_FIVE_WITH_BONUS_PRISE
import lotto.resources.Lotto.MATCH_FOUR_PRISE
import lotto.resources.Lotto.MATCH_SIX_PRISE
import lotto.resources.Lotto.MATCH_THREE_PRISE

enum class LottoMatchInfo(
    val value: Int,
    val prise: Double,
    val comment: (Int) -> String
) {
    MatchSix(6, MATCH_SIX_PRISE, { "6개 일치 (2,000,000,000원) - ${it}개" }),
    MatchFiveWithBonus(5, MATCH_FIVE_WITH_BONUS_PRISE, { "5개 일치, 보너스 볼 일치 (30,000,000원) - ${it}개" }),
    MatchFive(5, MATCH_FIVE_PRISE, { "5개 일치 (1,500,000원) - ${it}개" }),
    MatchFour(4, MATCH_FOUR_PRISE, { "4개 일치 (50,000원) - ${it}개" }),
    MatchThree(3, MATCH_THREE_PRISE, { "3개 일치 (5,000원) - ${it}개" }),
    MatchUnderThree(0, 0.0, { "0개 일치 ${it}" });
}



