package lotto.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoServiceTest {
	@Test
	fun `당첨 번호 쉼표가 없으면 ERROR`() {
		val input = "233"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}
	@Test
	fun `당첨 번호 입력시 숫자가 아니면 ERROR`() {
		val input = "1,d"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}
	@Test
	fun `당첨 번호 입력시 1~45의 숫자가 아니면 ERROR`() {
		val input = "2,65,4"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}
	@Test
	fun `당첨 번호 입력시 6개 숫자가 아니면 ERROR`() {
		val input = "2,4,7,27,45"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}
	@Test
	fun `당첨 번호 입력시 중복있으면 ERROR`() {
		val input = "1,1,3,4,5,6"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}

	@Test
	fun `보너스 번호 입력시 숫자가 아니면 ERROR`() {
		val input = "df"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}
	@Test
	fun `보너스 번호 입력시 1~45의 숫자가 아니면 ERROR`() {
		val input = "149"
		assertThrows<IllegalArgumentException> {
			LottoService().winningNumber(input)
		}
	}
}