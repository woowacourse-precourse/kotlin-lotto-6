package lotto.view

import lotto.constants.askBonusNumberMessage
import lotto.constants.askPurchaseAmountMessage
import lotto.constants.askWinningLottoNumberMessage
import lotto.domain.Lotto
import lotto.domain.Lottos

class Output {
    fun askPurchaseAmount(){
        println(askPurchaseAmountMessage)
    }

    fun askWinningLottoNumber(){
        println(askWinningLottoNumberMessage)
    }

    fun askBonusNumber(){
        println(askBonusNumberMessage)
    }

    fun printLotts(lottos: ArrayList<Lotto>){
        lottos.all {
            println(it)
            true
        }
    }
}