package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.message.ErrorMessage
import lotto.model.LottoModel
import lotto.view.LottoView
import kotlin.NumberFormatException

class LottoController(private val model: LottoModel, private val view : LottoView) {

    fun run() {
        var input_money = inputMoney()
        view.showTicket(input_money.second)
        var buy_lotto_number = model.getRandomTicket(input_money)
        view.showTicketNumber(buy_lotto_number,input_money)
        var winning_number = setWinningNumber()
        var bonus_number = setBonusNumber(winning_number)
        var ticket_result = model.checkWinningTicket(buy_lotto_number,winning_number,bonus_number,input_money.second)
        view.showWinning(ticket_result)
        var rate_of_return = model.getRateOfReturn(ticket_result,input_money.first)
        view.showRateOfReturn(rate_of_return)
    }

    fun inputMoney() : Pair<Int,Int>{
        while(true){
            try{
                view.inputMoney()
                var input_money = Console.readLine().toInt()
                checkDevide(input_money)
                var test_complete_input_money = InputMoneyTest(input_money)
                input_money = test_complete_input_money.getInputNumber()
                return Pair(input_money,input_money/1000)
            }catch (e: NumberFormatException){
                println(ErrorMessage.CHARACTER_IN_NUMBER)
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }
    fun checkDevide(input_money: Int){
        if((input_money % 1000) != 0){
            throw IllegalArgumentException(ErrorMessage.CAN_NOT_DIVIDE_NUMBER)
        }
    }
    fun setWinningNumber() : List<String> {
        while (true) {
            try {
                view.inputWinningNumber()
                var winning_number = Console.readLine().split(",").toList()
                checkWinningNumberException(winning_number)
                var test_complete_winning_number = WinningNumberTest(winning_number)
                return test_complete_winning_number.getWinningNumber()
            } catch (e: IllegalArgumentException) {
                print(e.message)
            } catch (e: NumberFormatException){
                println(e.message)
            }
        }
    }

    fun checkWinningNumberException(winning_number: List<String>){
        checkWinningNumberLength(winning_number)
        checkWinningNumberDuplicated(winning_number)
        checkWinningNumberType(winning_number)
        checkWinningNumberValue(winning_number)
    }

    fun checkWinningNumberLength(winning_number: List<String>) {
        if (winning_number.size >= 7) {
            throw IllegalArgumentException(ErrorMessage.ANSWER_NUMBER_AMOUNT_EXCEED)
        } else if (winning_number.size <= 5) {
            throw IllegalArgumentException(ErrorMessage.ANSWER_NUMBER_AMOUNT_LITTLE)
        }
    }

    fun checkWinningNumberDuplicated(winning_number: List<String>) {
        var check_duplicated = ArrayList<String>()
        for(idx in 0..winning_number.size-1){
            if(check_duplicated.contains(winning_number.get(idx)))
                throw IllegalArgumentException(ErrorMessage.ANSWER_DUPLICATED_NUMBER)
            else
                check_duplicated.add(winning_number.get(idx))
        }
    }

    fun checkWinningNumberType(winning_number: List<String>){
        for(idx in 0..winning_number.size-1){
            if(winning_number.get(idx).matches(Regex("[A-Za-z\\s]*")))
                throw NumberFormatException(ErrorMessage.ANSWER_NOT_A_NUMBER)
        }
    }

    fun checkWinningNumberValue(winning_number: List<String>){
        for(idx in 0..winning_number.size-1){
            if(winning_number.get(idx).toInt() > 45 || winning_number.get(idx).toInt() < 1)
                 throw IllegalArgumentException(ErrorMessage.ANSWER_NUMBER_VALUE_EXCEED)
        }
    }

    fun setBonusNumber(winning_number: List<String>) : Int{
        while(true){
            try{
                view.inputBonusNumber()
                var bonus_number = Console.readLine().toInt()
                checkBonusNumberValue(bonus_number)
                checkBonusNumberDuplicated(winning_number,bonus_number)
                bonus_number = BonusNumberTest(winning_number,bonus_number).getBonusNumber()
                return bonus_number
            }catch (e: NumberFormatException){
                print(ErrorMessage.BONUS_NUMBER_NOT_A_NUMBER)
            }catch (e: IllegalArgumentException){
                print(e.message)
            }
        }
    }

    fun checkBonusNumberValue(bonus_number : Int){
        if(bonus_number > 45 || bonus_number < 1){
            throw IllegalArgumentException(ErrorMessage.BONUS_NUMBER_VALUE_OVER)
        }
    }

    fun checkBonusNumberDuplicated(winning_number: List<String>, bonus_number: Int){
        var bonus = bonus_number.toString()
        if(winning_number.contains(bonus)){
            throw IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED_IN_ANSWER_NUMBER)
        }
    }
}

