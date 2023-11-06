package lotto.model

import lotto.resources.Lotto.INIT_VALUE
import lotto.resources.Lotto.MATCH_FIVE_PRISE
import lotto.resources.Lotto.MATCH_FIVE_WITH_BONUS_PRISE
import lotto.resources.Lotto.MATCH_FOUR_PRISE
import lotto.resources.Lotto.MATCH_SIX_PRISE
import lotto.resources.Lotto.MATCH_THREE_PRISE

enum class LottoResult(
    var value: Int,
    val prise: Double,
    val comment: (Int) -> String
) {
    MatchSix(INIT_VALUE, MATCH_SIX_PRISE, { "6개 일치 (2,000,000,000원) - ${it}개" }),
    MatchFiveWithBonus(INIT_VALUE, MATCH_FIVE_WITH_BONUS_PRISE, { "5개 일치, 보너스 볼 일치 (30,000,000원) - ${it}개" }),
    MatchFive(INIT_VALUE, MATCH_FIVE_PRISE, { "5개 일치 (1,500,000원) - ${it}개" }),
    MatchFour(INIT_VALUE, MATCH_FOUR_PRISE, { "4개 일치 (50,000원) - ${it}개" }),
    MatchThree(INIT_VALUE, MATCH_THREE_PRISE, { "3개 일치 (5,000원) - ${it}개" });
}



