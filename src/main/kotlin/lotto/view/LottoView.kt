package lotto.view

import lotto.Lotto
import lotto.message.ControlMessage
import lotto.message.ErrorMessage
import kotlin.math.E

class LottoView {
    fun inputMoney() {
        println(ControlMessage.INPUT_MONEY)
    }

    fun showTicket(num: Int) {
        println("\n${num}${ControlMessage.SHOW_TICKET}")
    }

    fun showTicketNumber(buy_lotto_number: Array<Lotto?>, inputMoney: Pair<Int, Int>) {
        for (ticket in 0..inputMoney.second - 1) {
            print("[")
            for (num in 0..4) {
                print("${buy_lotto_number[ticket]!!.getTicketNumber().toList().get(num)}, ")
            }
            println("${buy_lotto_number[ticket]!!.getTicketNumber().toList().get(5)}]")
        }
    }

    fun inputWinningNumber() {
        println(ControlMessage.INPUT_WINNING_NUMBER)
    }

    fun inputBonusNumber() {
        println(ControlMessage.INPUT_BONUS_NUMBER)
    }

    fun showWinning(choose_result: IntArray) {
        print(ControlMessage.SHOW_WINNING)
        showCountAgreement(EnumMessage.THREE_AGREEMENT, choose_result)
        showCountAgreement(EnumMessage.FOUR_AGREEMENT, choose_result)
        showCountAgreement(EnumMessage.FIVE_AGREEMENT, choose_result)
        showCountAgreement(EnumMessage.FIVE_AND_ONE_BONUS_AGREEMENT, choose_result)
        showCountAgreement(EnumMessage.SIX_AGREEMENT, choose_result)
    }

    fun showCountAgreement(enumMessage: EnumMessage, choose_result: IntArray) = when (enumMessage) {
        EnumMessage.THREE_AGREEMENT -> println("${ControlMessage.SHOW_THREE_AGREEMENT}${choose_result[0]}개")
        EnumMessage.FOUR_AGREEMENT -> println("${ControlMessage.SHOW_FOUR_AGREEMENT}${choose_result[1]}개")
        EnumMessage.FIVE_AGREEMENT -> println("${ControlMessage.SHOW_FIVE_AGREEMENT}${choose_result[2]}개")
        EnumMessage.FIVE_AND_ONE_BONUS_AGREEMENT -> println("${ControlMessage.SHOW_FIVE_AND_ONE_BONUS_AGREEMENT}${choose_result[4]}개")
        EnumMessage.SIX_AGREEMENT -> println("${ControlMessage.SHOW_SIX_AGREEMENT}${choose_result[3]}개")
    }

    fun showRateOfReturn(rate_of_return: String) {
        println("${ControlMessage.SHOW_RATE_OF_RETURN}${rate_of_return}%입니다.")
    }
}

enum class EnumMessage() {
    THREE_AGREEMENT,
    FOUR_AGREEMENT,
    FIVE_AGREEMENT,
    FIVE_AND_ONE_BONUS_AGREEMENT,
    SIX_AGREEMENT
}


