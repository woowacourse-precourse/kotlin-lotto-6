package lotto.domain

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class LottoMakeTest {
    @Test
    fun `입력받은 금액만큼 로또를 발행한다`() {
        val amount = 5000
        val lotto = LottoMake().resultLottoNumber(amount / 1000)
        assertTrue(lotto.size == amount / 1000)
    }
}