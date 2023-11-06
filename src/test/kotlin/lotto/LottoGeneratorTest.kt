package lotto

import domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoGeneratorTest {
    @Test
    fun `발행된 로또가 숫자 범위를 벗어 나는지 확인`() {
        assertTrue(LottoGenerator().createLottoNumber().all { it in  LOTTO_RANGE })
    }

    @Test
    fun `발행된 로또의 숫자 개수가 6이 맞는지 확인`() {
        assertEquals(LOTTO_COUNT, LottoGenerator().createLottoNumber().size)
    }

    companion object {
        private val LOTTO_RANGE = 1..45
        private const val LOTTO_COUNT = 6
    }
}