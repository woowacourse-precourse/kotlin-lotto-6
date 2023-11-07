package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


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
    fun `로또 번호 출력`() {
        val result = Lotto(listOf(1,2,3,4,5,6)).printnumbers()

        assertThat(result).isEqualTo(println("[1, 2, 3, 4, 5, 6]"))
    }

    @Test
    fun `로또 번호 체크`() {
        val result = Lotto(listOf(1,2,3,4,5,6)).checklotto(listOf(1,2,3,4,5,6), 7)

        assertThat(result).isEqualTo(MatchCount.ALL)
    }

    @Test
    fun `통계 출력 확인`() {
        val result = printtotal(listOf(MatchCount.ONE, MatchCount.TWO, MatchCount.THREE), 3000)
        val printexpect = "3개 일치 (5,000원) - 1개\n4개 일치 (50,000원) - 0개\n5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n6개 일치 (2,000,000,000원) - 0개\n총 수익률은 166.67%입니다."
        assertThat(result).isEqualTo(println(printexpect))
    }
}
