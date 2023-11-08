package lotto.view

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream


class InputViewTest {
    private fun command(vararg args: String) {
        val buf = java.lang.String.join("\n", *args).toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }

    @AfterEach
    fun consoleClose() {
        Console.close()
    }

    @Test
    fun `구입 금액 입력시 정수가 아니면 예외가 발생한다`() {
        val input = "1000j"
        try {
            assertThrows<IllegalArgumentException> {
                command(input)
                InputView.inputPurchasedMoney()
            }
        } finally {
            Console.close()
        }
    }

    @Test
    fun `당첨 번호 입력시 각각 정수가 아니면 예외가 발생한다`() {
        val input = "1,2,3i,j4,33"
        try {
            assertThrows<IllegalArgumentException> {
                command(input)
                InputView.inputWinningNumbers()
            }
        } finally {
            Console.close()
        }
    }

    @Test
    fun `보너스 번호 입력시 정수가 아니면 예외가 발생한다`() {
        val input = "3o"
        try {
            assertThrows<IllegalArgumentException> {
                command(input)
                InputView.inputBonusNumber()
            }
        } finally {
            Console.close()
        }
    }
}