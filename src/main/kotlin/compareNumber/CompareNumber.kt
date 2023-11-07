package compareNumber

import lotto.Lotto
import output.CompareResult
import output.UserInterface

class CompareNumber {
    fun showResult(ranks: List<Int>){
        println(UserInterface.OUTPUT_WINNING_RESULT.mention)

        for (index in 0 until ranks.size) {
            val mention = CompareResult.values()[index].mention + ranks[index] + "개"
            println(mention)
        }

    }
    fun resultOfLotto(lottos: MutableList<Lotto>, winningNumber: MutableList<String>) : List<Int>{

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

    private fun countMatchingNumber(input: List<Int>): List<Int>{
        var first = 0
        var second = 0
        var third = 0
        var fourth = 0
        var fifth = 0

        println("INPUT DEBUG : $input")
        var matchingNumbers = input.filter { it == 1 }
        val rank = Rank.RANK.determineRank(matchingNumbers)
        when (rank.toString()){
            "FIRST" -> first++
            "SECOND" -> second++
            "THIRD" -> third++
            "FOURTH" -> fourth++
            "FIFTH" -> fifth++
        }

        var result = listOf(first, second, third, fourth, fifth)
        return result
    }
}