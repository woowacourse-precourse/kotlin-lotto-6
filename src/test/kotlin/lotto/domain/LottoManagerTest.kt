package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoManagerTest {
    @Test
    fun `로또 당첨 번호로 문자를 입력받을 수 없다`() {
        //given
        val lottoManager = LottoManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setWinningNumbers(listOf("가", "나", "다", "라", "마", "바"))
        }
    }

    @Test
    fun `로또 당첨 번호로 중복된 숫자를 입력받을 수 없다`() {
        //given
        val lottoManager = LottoManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setWinningNumbers(listOf(1, 1, 1, 1, 1, 1))
        }
    }

    @Test
    fun `로또 당첨 번호로 음수를 입력받을 수 없다`() {
        //given
        val lottoManager = LottoManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setWinningNumbers(listOf(-1, -2, -3, -4, -5, -6))
        }
    }

    @Test
    fun `로또 당첨 번호로 46이상의 수를 입력받을 수 없다`() {
        //given
        val lottoManager = LottoManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setWinningNumbers(listOf(46, 47, 48, 49, 50, 51))
        }
    }

    @Test
    fun `로또 보너스 번호로 46이상의 수를 입력받을 수 없다`() {
        //given
        val lottoManager = LottoManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setBonusNumber(46)
        }
    }

    @Test
    fun `로또 보너스 번호로 음수를 입력받을 수 없다`() {
        //given
        val lottoManager = LottoManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setBonusNumber(-1)
        }
    }

    @Test
    fun `로또 보너스 번호는 당첨 번호와 중복될 수 없다`() {
        //given
        val lottoManager = LottoManager()
        lottoManager.setWinningNumbers(listOf(1, 2, 3, 4, 5, 6))

        //when

        //then
        assertThrows<IllegalArgumentException> {
            lottoManager.setBonusNumber(6)
        }
    }
}