package lotto.view


import lotto.util.Constants
import lotto.model.Rank

class Output {
    fun printWriteMoney() {
        println(Constants.WRITE_MONEY)
    }

    fun printPurchase(purchaseNumber: Int) {
        println(purchaseNumber.toString() + Constants.PURCHASE_NUMBER)
    }

    fun printLottoNumbers(lotto: List<Int>) {
        println(lotto)
    }

    fun printWriteAnswer() {
        println(Constants.WRITE_JACKPOT)
    }

    fun printWriteBonus() {
        println(Constants.WRITE_BONUS)
    }

    fun printAnswerCompare(answers: List<Int>, profit: Float) {
        println(Constants.COMPARE_ANSWER)
        println(Constants.THREE_DASH)
        for ((index, rank) in Rank.entries.withIndex()) {
            println(rank.label + answers[index] + rank.countLabel)
        }
        println(Constants.TOTAL_PROFIT + profit + Constants.PERCENT)
    }
}