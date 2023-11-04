package lotto.view

import lotto.message.ControlMessage
import javax.crypto.KeyAgreement

class LottoView {
    fun inputMoney(){
        println(ControlMessage.INPUT_MONEY)
    }
    fun showTicket(num : Int){
        println("\n${num}${ControlMessage.SHOW_TICKET}")
    }

    fun showTicketNumber(buy_lotto_number : Array<Array<Int>>,inputMoney : Pair<Int,Int>){
        for(ticket in 1..inputMoney.second){
            print("[")
            for(num in 0..4){
                print("${buy_lotto_number[ticket-1][num]}, ")
            }
            println("${buy_lotto_number[ticket-1][5]}]")
        }
    }

    fun inputWinningNumber(){
        println(ControlMessage.INPUT_WINNING_NUMBER)
    }
    fun inputBonusNumber(){
        println(ControlMessage.INPUT_BONUS_NUMBER)
    }
    fun showWinning(agreement : IntArray){
        println(ControlMessage.SHOW_WINNING)
        for(rank in 5 downTo 1){
            showCountAgreement(rank,agreement)
        }
    }
    fun showCountAgreement(rank : Int,agreement: IntArray){
        if (rank== 5) {
            println("${ControlMessage.SHOW_THREE_AGREEMENT}${agreement[0]}개")
        } else if (rank == 4) {
            println("${ControlMessage.SHOW_FOUR_AGREEMENT}${agreement[1]}개")
        } else if (rank == 3) {
            println("${ControlMessage.SHOW_FIVE_AGREEMENT}${agreement[2]}개")
        } else if (rank == 2) {
            println("${ControlMessage.SHOW_FIVE_AND_ONE_BONUS_AGREEMENT}${agreement[3]}개")
        } else if (rank == 1) {
            println("${ControlMessage.SHOW_SIX_AGREEMENT}${agreement[4]}개")
        }
    }
    fun showRateOfReturn(rate_of_return : Double){
        println("${ControlMessage.SHOW_RATE_OF_RETURN}${rate_of_return}입니다.")
    }


}