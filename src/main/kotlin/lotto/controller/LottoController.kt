package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.message.ErrorMessage
import lotto.model.LottoModel
import lotto.view.LottoView
import org.mockito.internal.matchers.Null
import kotlin.NumberFormatException

class LottoController(private val model: LottoModel, private val view : LottoView) {
    fun run(){
        var input_money = inputMoney()
        view.showTicket(input_money.second)
        var buy_lotto_number = getRandomTicket(input_money)
        view.showTicketNumber(buy_lotto_number,input_money)
        var winning_number = setWinningNumber()
        view.inputBonusNumber()
        winning_number = setBonusNumber(winning_number)
        var choose_result = model.check(buy_lotto_number,winning_number,input_money.second)
        view.showWinning(choose_result)
        var rate_of_return = model.getRateOfReturn(choose_result,input_money.first)
        view.showRateOfReturn(rate_of_return)
    }

    fun inputMoney() : Pair<Int,Int>{
        while(true){
            try{
                view.inputMoney()
                var input_money = Console.readLine().toInt()
                check_devide(input_money)
                return Pair(input_money,input_money/1000)
            }catch (e: NumberFormatException){
                println(ErrorMessage.CHARACTER_IN_NUMBER)
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }
    fun check_devide(input_money: Int){
        if((input_money % 1000) != 0){
            return throw IllegalArgumentException(ErrorMessage.CAN_NOT_DIVIDE_NUMBER)
        }
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

    fun setWinningNumber() : List<String> {
        while (true) {
            try {
                view.inputWinningNumber()
                var winning_number = Console.readLine().split(",").toList()
                checkWinningNumberLength(winning_number)
                checkWinningNumberDuplicated(winning_number)
                checkWinningNumberTypeAndValue(winning_number)
                return winning_number
            } catch (e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }



    fun checkWinningNumberLength(winning_number: List<String>) {
        if (winning_number.size >= 7) {
            return throw IllegalArgumentException(ErrorMessage.ANSWER_NUMBER_AMOUNT_EXCEED)
        } else if (winning_number.size <= 5) {
            return throw IllegalArgumentException(ErrorMessage.ANSWER_NUMBER_AMOUNT_LITTLE)
        }
    }


    fun checkWinningNumberDuplicated(winning_number: List<String>) {
        var check_duplicated = ArrayList<String>()
        for(idx in 0..winning_number.size-1){
            if(check_duplicated.contains(winning_number.get(idx)))
                return throw IllegalArgumentException(ErrorMessage.ANSWER_DUPLICATED_NUMBER)
            else
                check_duplicated.add(winning_number.get(idx))
        }
    }

    fun checkWinningNumberTypeAndValue(winning_number: List<String>){
        for(idx in 0..winning_number.size-1){
            if(winning_number.get(idx).matches(Regex("[A-Za-z\\s]*")))
                return throw IllegalArgumentException(ErrorMessage.ANSWER_NOT_A_NUMBER)
            else if(winning_number.get(idx).toInt() > 45 || winning_number.get(idx).toInt() < 1)
                return throw IllegalArgumentException(ErrorMessage.ANSWER_NUMBER_VALUE_EXCEED)
        }
    }

    fun setBonusNumber(winning_number : List<String>) : List<String>{
        return winning_number + Console.readLine()
    }
}

