package lotto

import lotto.LottoUtil.commaString
import lotto.LottoUtil.isAllNumbers
import lotto.LottoUtil.isInLottoRange
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoUtilTest {

    @Test
    fun `숫자 문자열 판별`() {
        assertThat(LottoUtil.isStringNumber("12345")).isTrue()
    }

    @Test
    fun `숫자가 아닌 문자열 판별`() {
        assertThat(LottoUtil.isStringNumber("123a")).isFalse()
    }

    @Test
    fun `1000의 배수인 수 판별`() {
        assertThat(LottoUtil.isMultipleOf1000(2000)).isTrue()
        assertThat(LottoUtil.isMultipleOf1000(10000)).isTrue()
    }

    @Test
    fun `1000의 배수가 아닌 수 판별`() {
        assertThat(LottoUtil.isMultipleOf1000(999)).isFalse()
        assertThat(LottoUtil.isMultipleOf1000(1025)).isFalse()
        assertThat(LottoUtil.isMultipleOf1000(9999)).isFalse()
    }

    @Test
    fun `모든 문자열이 숫자로 변환될 수 있는 경우 확인`() {
        assertThat(listOf("123", "456", "678").isAllNumbers())
            .isTrue()
    }

    @Test
    fun `적어도 하나의 문자열이 숫자로 변환될 수 없는 경우 확인`() {
        assertThat(listOf("123", "456", "abc").isAllNumbers())
            .isFalse()
    }

    @Test
    fun `주어진 수가 로또 숫자 범위 내에 포함되는지 확인`() {
        val numbers = listOf(1, 2, 0, 45, 47, -100)
        val result = numbers.map { number -> number.isInLottoRange() }
        assertThat(result)
            .containsExactly(true, true, false, true, false, false)
    }

    @Test
    fun `세 자리 이하의 수는 콤마가 찍히지 않아야 한다`() {
        assertThat(123.commaString)
            .isEqualTo("123")
    }

    @Test
    fun `네 자리 이상의 수는 콤마가 찍혀야 한다`() {
        assertThat(123456.commaString)
            .isEqualTo("123,456")
        assertThat(123456789.commaString)
            .isEqualTo("123,456,789")
        assertThat(1234567890.commaString)
            .isEqualTo("1,234,567,890")
    }

}