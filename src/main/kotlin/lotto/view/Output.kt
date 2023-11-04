package lotto.view


import lotto.model.Constants
import lotto.model.Lotto
import lotto.model.Random

class Output {
    fun printWriteMoney() {
        println(Constants.WRITE_MONEY)
    }

    fun printPurchase(purchaseNumber: Int) {
        println(purchaseNumber.toString()+Constants.PURCHASE_NUMBER)
    }

    fun printLottoNumbers(lotto:List<Int>){
        println(lotto)
    }

    fun printWriteAnswer() {
        println(Constants.WRITE_JACKPOT)
    }
    fun printWriteBonus() {
        println(Constants.WRITE_BONUS)
    }

    fun printAnswerCompare(answers:List<Int>,profit:Float) {
        println(Constants.COMPARE_ANSWER)
        println(Constants.THREE_DASH)
        println(Constants.THREE_SAME+answers[0]+Constants.COUNT)
        println(Constants.FOUR_SAME+answers[1]+Constants.COUNT)
        println(Constants.FIVE_SAME+answers[2]+Constants.COUNT)
        println(Constants.FIVE_WITH_BONUS_SAME+answers[3]+Constants.COUNT)
        println(Constants.SIX_SAME+answers[4]+Constants.COUNT)
        println(Constants.TOTAL_PROFIT+profit+Constants.PERCENT)
    }
}