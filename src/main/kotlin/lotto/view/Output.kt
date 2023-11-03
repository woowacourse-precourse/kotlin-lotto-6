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

    fun printLottoNumbers(purchaseNumber: Int){
        repeat(purchaseNumber){
            println(Lotto(Random().lottoGenerator()).serve())
        }
    }

    fun printWriteAnswer() {
        println(Constants.WRITE_JACKPOT)
    }

    fun printAnswerCompare(answers:List<Int>,profit:Float) {
        println(Constants.COMPARE_ANSWER)
        println(Constants.THREE_DASH)
        println(Constants.THREE_SAME+answers[0])
        println(Constants.THREE_SAME+answers[0])
        println(Constants.THREE_SAME+answers[0])
        println(Constants.THREE_SAME+answers[0])
        println(Constants.THREE_SAME+answers[0])
        println(Constants.TOTAL_PROFIT+profit+Constants.PERCENT)
    }
}