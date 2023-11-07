package lotto

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

}