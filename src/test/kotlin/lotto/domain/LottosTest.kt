package lotto.domain


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `generateLottos 메서드 사용시 입력된 숫자만큼 Lotto 객체를 생성하는지 확인`() {
        //given
        val amount = 10
        val lottos = Lottos(amount)

        //when
        lottos.generateLottos()

        //then
        assertThat(lottos).extracting("lottos").asList().hasSize(10)
    }

    @Test
    fun `getLottoRanks 메서드 사용시 모든 Lotto의 당첨 결과를 저장하고 있는 Map을 반환`() {
        //given
        val lottos = Lottos(10)
        lottos.generateLottos()
        val winningNumber = listOf(5, 10, 15, 20, 25, 30)
        val bonusNumber = 35
        val result = 10

        //when
        val rankCounts = lottos.getLottoRanks(winningNumber, bonusNumber)

        //then
        assertThat(rankCounts.values.sum()).isEqualTo(result)
    }
}