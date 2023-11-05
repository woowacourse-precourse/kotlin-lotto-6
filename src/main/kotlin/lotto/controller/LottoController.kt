package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.LottoAllocate
import lotto.view.LottoView

class LottoController(private val model: LottoAllocate, private val view : LottoView) {
    fun run(){
        view.inputMoney()
        val input_money = inputMoney()
        view.showTicket(input_money.second)
        var buy_lotto_number = getRandomTicket(input_money)
        view.showTicketNumber(buy_lotto_number,input_money)
        view.inputWinningNumber()
        var winning_number = setWinningNumber()
        view.inputBonusNumber()
        winning_number = setBonusNumber(winning_number)
    }

    fun inputMoney() : Pair<Int,Int>{
        val input_money = Console.readLine().toInt()
        return Pair(input_money,input_money/1000)
    }

    fun getRandomTicket(input_money : Pair<Int,Int>) : Array<Array<Int>> {
        var buy_lotto_number = Array(input_money.second){Array(6){ 0 } }
        for(ticket_num in 0..input_money.second-1){
            buy_lotto_number = selectRandomNumber(ticket_num,buy_lotto_number)
        }
        return buy_lotto_number
    }

    fun selectRandomNumber(ticket_num : Int,buy_lotto_number : Array<Array<Int>>) : Array<Array<Int>> {
        val number = Randoms.pickUniqueNumbersInRange(1,45,6)
        number.sort()
        for(num in 0..5){
            buy_lotto_number[ticket_num][num] = number.get(num).toInt()
        }
        return buy_lotto_number
    }

    fun setWinningNumber() : List<String>{
        var winning_number = Console.readLine().split(",").toList()
        return winning_number
    }

    fun setBonusNumber(winning_number : List<String>) : List<String>{
        return winning_number + Console.readLine()
    }


}