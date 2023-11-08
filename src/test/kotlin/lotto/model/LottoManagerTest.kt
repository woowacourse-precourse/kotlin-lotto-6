package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoManagerTest {

    private lateinit var lottoManager : LottoManager

    @BeforeEach
    fun setUp() {
        lottoManager = LottoManager()
    }

    @Test
    fun `수량에 맞게 로또가 발행이 되는지 테스트`() {
        val lottoTickets = lottoManager.issueLottoTicket(6)

        assertEquals(lottoTickets.size,6)
    }
}