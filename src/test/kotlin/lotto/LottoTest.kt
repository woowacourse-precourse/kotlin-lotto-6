package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.round


class LottoTest {
    val lottoController = LottoController()
    val lottoView = LottoView()
    val lottoCollection = LottoCollection()

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 금액이 1000 단위가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoController.checkLottoCost("1001")
        }
    }

    @Test
    fun `로또 금액이 0 이하인 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoController.checkLottoCost("0")
        }
    }

    @Test
    fun `생성한 로또 번호가 6개가 들어간다`() {
        val numbers = lottoController.generateNumbers()
        Assertions.assertThat(numbers.size).isEqualTo(6)
    }

    @Test
    fun `생성되는 숫자가 들어간다`() {
        val numberCollection: MutableList<Int> = mutableListOf()
        var num = 1
        while (numberCollection.size < 6) {
            val randNum = num ++
            if (!numberCollection.contains(randNum)) {
                numberCollection.add(randNum)
            }
        }
        Assertions.assertThat(numberCollection).contains(1,2,3,4,5,6)
    }

    @Test
    fun `중복되는 숫자 무시가 들어간다`() {
        val numberCollection: MutableList<Int> = mutableListOf()
        var num = 1
        while (numberCollection.size < 6) {
            val randNum = num
            if (!numberCollection.contains(randNum)) {
                numberCollection.add(randNum)
            } else if (numberCollection.contains(randNum)) {
                num ++
            }
        }
        Assertions.assertThat(numberCollection).contains(1,2,3,4,5,6)
    }

    @Test
    fun `금액에 맞게 로또가 생성된다`() {
        lottoController.lottoGenerate(3)
        Assertions.assertThat(lottoController.lottoCollection.lottoCollection.size).isEqualTo(3)
    }

    @Test
    fun `당첨 번호가 6개가 아닐 때 오류 발생한다`() {
        val inputWinningNumbers = "1,2,3,4,5,6,7"
        val inputCollection = inputWinningNumbers.split(",")
        val winningNumbers: MutableList<Int> = mutableListOf()
        for (number in inputCollection) {
            winningNumbers.add(number.toInt())
        }
        assertThrows<IllegalArgumentException> {
            lottoController.checkWinningNumbers(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호가 1-45가 아닐 때 오류 발생한다`() {
        val inputWinningNumbers = "1,2,3,4,5,46"
        val inputCollection = inputWinningNumbers.split(",")
        val winningNumbers: MutableList<Int> = mutableListOf()
        for (number in inputCollection) {
            winningNumbers.add(number.toInt())
        }
        assertThrows<IllegalArgumentException> {
            lottoController.checkWinningNumbers(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호가 저장이 된다`() {
        val inputWinningNumbers = "1,2,3,4,5,6"
        val inputCollection = inputWinningNumbers.split(",")
        val winningNumbers: MutableList<Int> = mutableListOf()
        for (number in inputCollection) {
            winningNumbers.add(number.toInt())
        }
        Assertions.assertThat(winningNumbers).contains(1,2,3,4,5,6)
    }

    @Test
    fun `당첨된 등수 리스트를 만든다`() {
        lottoCollection.putLotto(Lotto(listOf(1,2,3,4,5,6)))
        lottoCollection.putLotto(Lotto(listOf(1,2,3,4,5,7)))
        lottoCollection.putLotto(Lotto(listOf(1,2,3,4,7,8)))
        lottoCollection.putLotto(Lotto(listOf(1,2,3,7,8,9)))
        val winRankList = lottoCollection.checkWin(listOf(1,2,3,4,5,6), 7)
        val winRankNumList = mutableListOf(0,0,0,0,0,0)
        for (rank in winRankList) {
            winRankNumList[rank] ++
        }
        Assertions.assertThat(winRankNumList).isEqualTo(mutableListOf(0,1,1,0,1,1))
    }

    @Test
    fun `수익률을 계산한다`() {
        val rankNumList = mutableListOf(10,0,0,0,1,1)
        var sumCost: Double = 0.0
        val count = rankNumList.sum()
        for (i in 0..5) {
            when (i) {
                1 -> sumCost += 2000000000 * rankNumList[1]
                2 -> sumCost += 30000000 * rankNumList[2]
                3 -> sumCost += 1500000 * rankNumList[3]
                4 -> sumCost += 50000 * rankNumList[4]
                5 -> sumCost += 5000 * rankNumList[5]
            }
        }
        val averagePercent = round((sumCost / (count * 10)) * 10) / 10
        Assertions.assertThat(averagePercent).isEqualTo(458.3)
    }
    // 아래에 추가 테스트 작성 가능
}
