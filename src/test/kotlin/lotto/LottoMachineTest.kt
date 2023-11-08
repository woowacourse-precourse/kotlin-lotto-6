package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또 번호와 당첨번호(+보너스 번호)를 비교해 결과를 반환`() {
        val lottoMachine = LottoMachine("5000")

        val allLotto = listOf(
            listOf(1, 4, 10, 25, 32, 41),
            listOf(2, 8, 17, 19, 24, 31),
            listOf(1, 4, 16, 20, 32, 43),
            listOf(1, 4, 10, 19, 25, 41)
        )
        val winningNumber = listOf(1, 4, 10, 19, 25, 41)
        val bonusNumber = 32

        val result = lottoMachine.calculateMatchResults(allLotto, winningNumber, bonusNumber)

        val expectedResult = listOf(
            Pair(5, true),
            Pair(1, false),
            Pair(2, true),
            Pair(6, false)
        )

        assertEquals(expectedResult, result)
    }
}