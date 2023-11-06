package compareNumber

import lotto.Lotto
import compareNumber.Rank

class CompareNumber {
    var first = 0
    var second = 0
    var third = 0
    var fourth = 0
    var fifth = 0

    fun resultOfLotto(lottos: MutableList<Lotto>, winningNumber: MutableList<String>) {
        for (index in 0 until lottos.size) {
            var lotto = lottos[index]
            var result = compareLottoToWinningNumber(lotto, winningNumber)
            countMatchingNumber(result)
            println(result)
        }
    }

    private fun compareLottoToWinningNumber(lotto: Lotto, winningNumber: List<String>): List<Int> {
        val lottoNumbers = lotto.getNumbers()
        val result = mutableListOf<Int>()

        for (number in winningNumber) {
            val count = lottoNumbers.count { it == number.toInt() }
            result.add(count)
        }
        return result
    }

    private fun countMatchingNumber(input: List<Int>) {
        var matchingNumbers = input.filter { it.equals(1) }
        val rank = Rank.RANK.determineRank(matchingNumbers)
        when (rank.toString()){
            "FIRST" -> first++
            "SECOND" -> second++
            "THIRD" -> third++
            "FOURTH" -> fourth++
            "FIFTH" -> fifth++
        }
    }
}