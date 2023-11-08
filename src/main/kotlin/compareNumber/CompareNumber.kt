package compareNumber

import lotto.Lotto
import output.CompareResult
import output.UserInterface

class CompareNumber {
    val ranking = mutableListOf(0, 0, 0, 0, 0)
    fun showResult(ranks: List<Int>) {
        println(UserInterface.OUTPUT_WINNING_RESULT.mention)

        for (index in 0 until ranks.size) {
            val mention = CompareResult.values()[index].mention + ranks[index] + "개"
            println(mention)
        }

    }

    fun resultOfLotto(lottos: MutableList<Lotto>, winningNumber: MutableList<String>): List<Int> {

        var ranks = listOf<Int>()

        for (index in 0 until lottos.size) {
            var lotto = lottos[index]
            var result = compareLottoToWinningNumber(lotto, winningNumber)
            ranks = countMatchingNumber(result)

        }
        return ranks
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

    private fun countMatchingNumber(input: List<Int>): List<Int> {
        var winningCount = input.filter { it == 1 }.size
        var rank = Rank.RANK.determineRank(winningCount, input)

        println("Before : $ranking")

        when (rank.toString()) {
            "FIRST" -> ranking[4]++
            "SECOND" -> ranking[3]++
            "THIRD" -> ranking[2]++
            "FOURTH" -> ranking[1]++
            "FIFTH" -> ranking[0]++
        }

        println("After : $ranking")

        return ranking
    }
}