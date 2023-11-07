package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PointOfSalesTest {

    private lateinit var calculator: Calculator
    private lateinit var analyzer: Analyzer
    private lateinit var pos: PointOfSales

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
        analyzer = Analyzer(calculator)
        pos = PointOfSales(analyzer)
    }

    @Test
    fun `로또 발행 함수에 0을 입력하면 에러를 던진다`() {
        // given
        val quantity = 0

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            pos.issueLotto(quantity)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = PointOfSales.QUANTITY_SHOULD_BE_MORE_THEN_0
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @Test
    fun `로또 발행 함수에 -1을 입력하면 에러를 던진다`() {
        // given
        val quantity = -1

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            pos.issueLotto(quantity)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = PointOfSales.QUANTITY_SHOULD_BE_MORE_THEN_0
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @Test
    fun `로또 발행 함수에 -100을 입력하면 에러를 던진다`() {
        // given
        val quantity = -100

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            pos.issueLotto(quantity)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = PointOfSales.QUANTITY_SHOULD_BE_MORE_THEN_0
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @Test
    fun `로또 발행 함수에 1을 입력하면 로또 한 개를 반환한다`() {
        // given
        val quantity = 1

        // when
        val actual = pos.issueLotto(quantity)

        // then
        val expected = 1
        assertThat(actual).hasSize(expected)
    }

    @Test
    fun `로또 발행 함수에 100을 입력하면 로또 100개를 반환한다`() {
        // given
        val quantity = 100

        // when
        val actual = pos.issueLotto(quantity)

        // then
        val expected = 100
        assertThat(actual).hasSize(expected)
    }
}