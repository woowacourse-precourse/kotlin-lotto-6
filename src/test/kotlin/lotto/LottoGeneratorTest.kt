package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoGeneratorTest {

    @Test
    fun `1 ~ 45 사이의 중복되지 않는 6자리 숫자를 생성해서 로또 리스트에 담아 반환한다`() {
        val lottoGenerator = LottoGenerator(1000)
        assertDoesNotThrow { lottoGenerator.create() }
    }

    @Test
    fun `구입 금액만큼 로또를 발행한다_값 2000`() {
        val lottoGenerator = LottoGenerator(2000)
        lottoGenerator.create()
        assertThat(lottoGenerator.lottos).hasSize(2)
    }

    @Test
    fun `구입 금액만큼 로또를 발행한다_값 10_000`() {
        val lottoGenerator = LottoGenerator(10_000)
        lottoGenerator.create()
        assertThat(lottoGenerator.lottos).hasSize(10)
    }

    @Test
    fun `구입 금액만큼 로또를 발행한다_값 100_000`() {
        val lottoGenerator = LottoGenerator(100_000)
        lottoGenerator.create()
        assertThat(lottoGenerator.lottos).hasSize(100)
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외 발생_값 900`() {
        assertThrows<IllegalArgumentException> { LottoGenerator(900) }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외 발생_값 13800`() {
        assertThrows<IllegalArgumentException> { LottoGenerator(13800) }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외 발생_값 0`() {
        assertThrows<IllegalArgumentException> { LottoGenerator(0) }
    }
}