package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validator.getInstance()
    }

    @AfterEach
    fun tearDown() {
        Validator.releaseInstance()
    }

    @ParameterizedTest(name = "check {0}")
    @ValueSource(strings = ["1", "17", "500", "999", "1001", "20001", "100001"])
    @DisplayName("Validator : checkInputOfPurchasingCorrect() - success")
    fun `checkInputOfPurchasingCorrect 함수에 0보다 큰 양수 문자열 입력하면 true를 반환한다`(input: String) {
        // when
        val actual = validator.checkInputOfPurchasingCorrect(input)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "check {0}")
    @ValueSource(strings = ["천원", "10공0", "I000", "0", "-1", "-1000", "1 dollar", "lI00", "1000원", "2_000"])
    @DisplayName("Validator : checkInputOfPurchasingCorrect() - fail")
    fun `checkInputOfPurchasingCorrect 함수에 0보다 큰 양수가 아닌 문자열을 입력하면 false를 반환한다`(input: String) {
        // when
        val actual = validator.checkInputOfPurchasingCorrect(input)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }
}