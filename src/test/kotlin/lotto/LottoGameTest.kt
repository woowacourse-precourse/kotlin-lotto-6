package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ui.GameConsole
import ui.UserInputReader

class LottoGameTest {

    private val lottoGame = LottoGame(UserInputReader(), LottoMachine(), GameConsole(), LottoResultChecker())

    @Test
    fun When_Input_3000_Expect_3_3LottoTickets() {
        val input = 3000
        val (result1, result2) = lottoGame.generateLottoTickets(input)
        val expected = 3
        assertEquals(result1, expected)
        assertEquals(result2.size, expected)
    }

}