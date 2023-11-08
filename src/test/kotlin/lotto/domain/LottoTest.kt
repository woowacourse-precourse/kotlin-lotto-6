package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `sortNumbers 메서드 사용시 정렬된 오름차순 정렬된 int list를 반환`() {
        //given
        val lotto = Lotto(listOf(1, 5, 3, 4, 6, 2))

        //then
        assertThat(lotto.sortNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `getRank 메서드 사용시 당첨 번호와 보너스 번호를 비교해 Lotto의 당첨 결과를 출력`() {
        //given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNUmber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        //then
        assertThat(lotto.getRank(winningNUmber,bonusNumber)).isEqualTo(Rank.FIRST)
    }
}
