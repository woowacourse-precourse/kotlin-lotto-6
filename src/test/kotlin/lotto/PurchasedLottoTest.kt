package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.model.Lotto
import lotto.model.PurchasedLotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchasedLottoTest {
    @Test
    fun `구매한 로또의 등수가 제대로 나오는지 확인`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                Lotto(listOf(8, 21, 23, 41, 42, 43))
                val purchasedLotto = PurchasedLotto()

                purchasedLotto.setPurchasedLotto(listOf(8, 21, 23, 41, 42, 43), 7)
                val result = purchasedLotto.getWinPrize()
                Assertions.assertThat(result).isEqualTo(LOTTO_FIRST_WIN_COST)
            },
            listOf(8, 21, 23, 41, 42, 43),
        )
    }
}