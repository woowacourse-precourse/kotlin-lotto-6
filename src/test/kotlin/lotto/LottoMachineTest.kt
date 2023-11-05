package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun When_InputPrice_Expect_Count() {
        val input = 8000
        val expected = 8
        assertEquals(lottoMachine.calculateNumberOfLotto(input), expected)
    }

    @Test
    fun When_getLottoTickets_Expect_ListWithCorrectSize() {
        val input = lottoMachine.calculateNumberOfLotto(8000)
        val expected = 8
        val result = lottoMachine.getLottoTickets(input)
        assertEquals(result.size, expected)
    }

    @Test
    fun When_GenerateLotto_Expect_AscendingOrder() {
        val input = listOf(6, 5, 4, 3, 2, 1)
        val expected = "[1, 2, 3, 4, 5, 6]"
        assertEquals(lottoMachine.generateLotto(input).toString(), expected)
    }

    @Test
    fun When_GenerateRanDomNumbers_Expect_NoDuplicate() {
        repeat(100) {
            val numbers = lottoMachine.generateLottoNumbers()
            assertEquals(numbers.size,numbers.toSet().size)
        }
    }

}