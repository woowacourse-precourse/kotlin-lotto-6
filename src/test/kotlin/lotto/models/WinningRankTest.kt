package lotto.models

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningRankTest {

    @ParameterizedTest
    @CsvSource(
        "3, false, FIFTH",
        "4, false, FOURTH",
        "5, false, THIRD",
        "5, true, SECOND",
        "6, false, FIRST",

        "0, false, NOTHING",
        "0, true, NOTHING",
        "7, false, NOTHING",
    )
    fun `로또 번호와 보너스 번호 일치 여부에 따라 등수가 일치하는지 확인한다`(
        matchedCount: Int,
        isMatchedBonus: Boolean,
        expectedRank: WinningRank
    ) {
        val winningRank = WinningRank.find(matchedCount, isMatchedBonus)

        assertThat(winningRank).isEqualTo(expectedRank)
    }
}