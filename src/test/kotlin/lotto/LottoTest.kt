package lotto

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7), listOf(1, 2, 3, 4, 5, 6), 10)
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5, 6), 10)
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `랜덤넘버 테스트`() {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers)
    }
}
