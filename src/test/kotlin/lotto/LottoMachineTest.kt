package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun When_InputPrice_Expect_Int() {
        val input = 8000
        val expected = 8
        assertEquals(lottoMachine.calculateNumberOfLotto(input), expected)
    }
}