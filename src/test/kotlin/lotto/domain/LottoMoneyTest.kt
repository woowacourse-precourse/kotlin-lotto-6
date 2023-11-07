package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMoneyTest {
    @Test
    fun `로또 머니가 정수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMoney.from("1000j")
        }
    }

    @Test
    fun `로또 머니가 1000의 배수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMoney.from("1500")
        }
    }

    @Test
    fun `로또 머니가 양수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMoney.from("-1000")
        }
    }

    @Test
    fun `정상적인 로또 입력 처리`() {
        val lottoMoney = LottoMoney.from("5000")
        assertThat(lottoMoney.money).isEqualTo(5000)
    }
}