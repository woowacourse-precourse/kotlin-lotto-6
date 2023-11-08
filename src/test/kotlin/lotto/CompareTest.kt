package lotto

import org.junit.jupiter.api.Test

class CompareTest {
    @Test
    fun `로또의 번호와 당첨번호를 비교해서 일치한 갯수를 구한다`() {
        val lottoNumbers = Lotto(mutableListOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = mutableListOf(3, 4, 5, 6, 7, 8, 9)
        var result = mutableListOf<Int>()
        val answer = mutableListOf(1, 1, 1, 1, 0, 0, 0)

        //일치하는 숫자는 1로 불일치하는 숫자는 0으로 result에 담긴다
        for (number in winningNumbers) {
            val checkOfLotto = lottoNumbers.getNumbers().count { it == number.toInt() }
            result.add(checkOfLotto)
        }
        require(answer == result)
    }

    @Test
    fun `당첨 번호와 로또 번호가 일치하는 갯수를 통해 등수를 정한다`() {
        val checkLottoResult = mutableListOf(1, 1, 1, 1, 0, 0, 0)
        val count = checkLottoResult.count() { it == 1 }
        val answer = "FOURTH"

        val result = when (count) {
            6 -> if (checkLottoResult.last() == 0) "FIRST" else "SECOND"
            5 -> "THIRD"
            4 -> "FOURTH"
            3 -> "FIFTH"
            else -> "NONE"
        }

        require(result == answer)
    }
}