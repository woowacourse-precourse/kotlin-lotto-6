package lotto.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoServiceTest {
	@Test
	fun `로또 구입 금액이 1000 단위의 숫자가 아니면 ERROR`() {
		assertThrows<IllegalArgumentException> {
			LottoService().purchaseLotto("300")
		}
		assertThrows<IllegalArgumentException> {
			LottoService().purchaseLotto("3000d")
		}
	}

	@Test
	fun `구입 금액에 따른 로또 개수 확인`() {
		val input = "123000"
		val result = 123
		assertThat(LottoService().purchaseLotto(input)).isEqualTo(result)
	}
}