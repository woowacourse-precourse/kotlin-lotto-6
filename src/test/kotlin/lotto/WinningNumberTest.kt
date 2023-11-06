package lotto

import lotto.controller.WinningNumberTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest{

    @Test
    fun `당첨 숫자의 갯수가 적을 시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningNumberTest(listOf("1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `당첨 숫자의 갯수가 많을 시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningNumberTest(listOf("1", "2", "3", "4", "5", "6", "7"))
        }
    }

    @Test
    fun `당첨 숫자에 중복된 숫자가 있으면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningNumberTest(listOf("1", "2", "3", "4", "5", "1"))
        }
    }

    @Test
    fun `당첨 숫자가 범위를 넘는다면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningNumberTest(listOf("0", "2", "3", "4", "5", "46"))
        }
    }

    @Test
    fun `당첨 숫자 내부에 문자가 발견되면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningNumberTest(listOf("1", "2", "3", "4", "5", "k"))
        }
    }

}