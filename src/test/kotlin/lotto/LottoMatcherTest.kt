package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMatcherTest {
    val target = TargetLottoStatus()
    val lottos = LottoStatus()
    val myLottoMatcher = LottoMatcher(target, lottos)

    @Test
    fun `2등과 3등 나누기`() {
        target.lottoNumbers = listOf(1,2,3,4,5,6).toMutableList()
        target.bonusNumber = 7
        val secondPlace = Lotto(listOf(1,2,3,4,5,7))
        val thirdPlace = Lotto(listOf(1,2,3,4,5,8))

        val correctCountForSP = secondPlace.compareNumbers(target.lottoNumbers)
        val isBonusCorrectForSP = secondPlace.compareBonusNumber(target.bonusNumber)
        val correctCountForTP = thirdPlace.compareNumbers(target.lottoNumbers)
        val isBonusCorrectForTP = thirdPlace.compareBonusNumber(target.bonusNumber)

        assertThat(myLottoMatcher.checkRank(correctCountForSP,isBonusCorrectForSP)).isEqualTo(Rank.SECOND)
        assertThat(myLottoMatcher.checkRank(correctCountForTP,isBonusCorrectForTP)).isEqualTo(Rank.THIRD)
    }
    @Test
    fun `상금과 wincount 변화 확인`() {
        val previousProfit = myLottoMatcher.profitSum
        val previousCountOfRank3 = myLottoMatcher.winCount[3]
        myLottoMatcher.takeRankPrize(Rank.THIRD)

        assertThat(myLottoMatcher.profitSum).isEqualTo(previousProfit+Rank.THIRD.winnerPrize)
        assertThat(myLottoMatcher.winCount[3]).isEqualTo(previousCountOfRank3+1)
    }
}