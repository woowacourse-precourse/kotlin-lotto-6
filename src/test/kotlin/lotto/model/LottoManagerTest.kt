package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoManagerTest {

    @Test
    fun `lottoes가 제대로 생성되었는지 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val lottoManager = LottoManager(PURCHASE_AMOUNT)
                assertEquals(lottoManager.lottoes.size, PURCHASE_AMOUNT / LOTTO_PRICE)

            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12),
            listOf(13, 14, 15, 16, 17, 18),
            listOf(19, 20, 21, 22, 23, 24),
            listOf(25, 26, 27, 28, 29, 30),
        )
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val PURCHASE_AMOUNT = 5000
    }

}