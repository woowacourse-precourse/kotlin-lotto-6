package lotto.domain.lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) })
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또에 특정 로또 번호가 있는지 검사`() {
        // given
        val lottoNumer = LottoNumber(5)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        // when
        val result = lotto.isContainLottoNumber(lottoNumer)
        // then
        assertEquals(true, result)
    }

    @Test
    fun `특정 로또와 중복되는 숫자가 몇개 있는지 검사`() {
        // given
        val inputLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lotto = Lotto(listOf(5, 6, 7, 8, 9, 10).map { LottoNumber(it) })
        // when
        val result = lotto.getLottoMatchCount(inputLotto)
        // then
        assertEquals(2, result)
    }

    @Test
    fun `문자열 출력시 오름차순으로 정렬하여 출력`() {
        // given
        val lotto = Lotto(listOf(10, 1, 7, 43, 38, 12).map { LottoNumber(it) })
        // when
        val result = lotto.toString()
        // then
        assertEquals("[1, 7, 10, 12, 38, 43]", result)
    }
}
