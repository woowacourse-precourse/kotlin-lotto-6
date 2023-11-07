package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SaleTest {
    private lateinit var sale: Sale

    @BeforeEach
    fun setUp() {
        sale = Sale()
    }

    @Test
    fun `랜덤 번호를 받아서 실제 로또 용지를 생성`() {
        val input = listOf(5, 3, 1, 2, 4, 6)

        val expected = sale.createLottoTicket(input)

        assertEquals(expected, listOf(1, 2, 3, 4, 5, 6))
    }
}