package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `로또 티켓을 개수에 맞게 생성하는지 확인`() {
        val lottoGenerateCount = 5
        val lottoGenerator = LottoGenerator(lottoGenerateCount)

        val lottoTickets = lottoGenerator.generateLottoTickets()

        assertEquals(lottoGenerateCount, lottoTickets.size)
    }
}