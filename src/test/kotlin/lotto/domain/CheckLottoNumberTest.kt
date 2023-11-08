package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CheckLottoNumberTest{
    private val buyLottos =
        listOf(
            Lotto(listOf(8,9,10,11,12,13)),
            Lotto(listOf(4,5,15,31,32,44)),
            Lotto(listOf(1,2,3,4,5,6)),
            Lotto(listOf(1,2,3,4,7,8)),
            Lotto(listOf(1,2,3,4,5,8))
        )

    private val winningNumbers = Lotto(listOf(1,2,3,4,5,6))
    private val bonusNumber = 7
    private val winningCount = mutableMapOf<Stats, Int>()

    val checkLottoNumber = CheckLottoNumber(buyLottos, winningNumbers, bonusNumber)

    @Test
    @DisplayName("당첨 번호에서 일치하는 숫자의 개수 확인")
    fun getMatchWinningNumberCountSIX() {
        val lottoMatchedCount = listOf(0, 2, 6, 5, 5)
        for (index in buyLottos.indices) {
            assertThat(checkLottoNumber.getMatchNumberCount(buyLottos[index])).isEqualTo(lottoMatchedCount[index])
        }
    }

}