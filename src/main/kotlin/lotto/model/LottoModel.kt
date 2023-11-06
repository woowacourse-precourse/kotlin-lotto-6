package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoModel {

    fun getRandomTicket(input_money : Pair<Int,Int>) : Array<Lotto?> {
        val buy_lotto_number = Array<Lotto?>(input_money.second){null}
        for(ticket_num in 0..input_money.second-1){
            val number = Randoms.pickUniqueNumbersInRange(1,45,6)
            val lotto = Lotto(number.sorted())
            buy_lotto_number[ticket_num] = lotto
        }
        return buy_lotto_number
    }

    fun checkWinningTicket(buy_lotto_number : Array<Lotto?>,winning_number : List<String>,bonus_number : Int,size : Int) : IntArray{
        var ticket_result = IntArray(6)
        ticket_result = chooseWinning(buy_lotto_number,winning_number,bonus_number,size,ticket_result)
        return ticket_result
    }
    fun chooseWinning(buy_lotto_number : Array<Lotto?>, winning_number : List<String>, bonus_number: Int, size : Int, ticket_result : IntArray) : IntArray{
        for (ticket in 0..size - 1) {
            var get_ticket_line = getTicketLine(buy_lotto_number,ticket)//선택된 로또의 번호들을 저장하는 함수
            var winning_lotto_num = checkLottoWinningAgreement(get_ticket_line,winning_number)//당첨과 같은 번호와 갯수를 저장하는 PAIR 생성
            winning_lotto_num = checkLottoBonusAgreement(get_ticket_line,bonus_number,winning_lotto_num)
            ticket_result[getWinningStatistics(winning_lotto_num)] += 1
        }
        return ticket_result
    }

    fun getTicketLine(buy_lotto_number : Array<Lotto?>,ticket: Int) : ArrayList<Int>{
        var get_ticket_line = ArrayList<Int>()
        for(line in 0..5){
            get_ticket_line.add(buy_lotto_number[ticket]!!.getTicketNumber().toList().get(line))
        }
        return get_ticket_line
    }

    fun checkLottoWinningAgreement(get_ticket_line : ArrayList<Int>, winning_number : List<String>) : Int{
        var winning_lotto_number = 0
        for (idx in 0..5) {
            if(get_ticket_line.contains(winning_number.get(idx).toInt())){
                winning_lotto_number++
            }
        }
        return winning_lotto_number
    }

    fun checkLottoBonusAgreement(get_ticket_line : ArrayList<Int>,bonus_number: Int,winning_lotto_num : Int) : Int{
        var winning_bonus_number = 0
        if(get_ticket_line.contains(bonus_number) && winning_lotto_num == 5){
            winning_bonus_number += 2
        }
        return winning_lotto_num + winning_bonus_number
    }

    fun getWinningStatistics(winning_lotto_num: Int) : Int{
        if (winning_lotto_num >= 3) {
            return winning_lotto_num-3
        }
        return 5
    }

    fun getRateOfReturn(ticket_result: IntArray, insert_money : Int) : String {
        var money: Int = 0
        for(idx in 0..4){
            money += plusMoney(idx,ticket_result)
        }
        var rate_of_return = ((money.toDouble()/insert_money.toDouble()) * 100)
        val rate_of_return_str = String.format("%.1f",rate_of_return)
        return rate_of_return_str
    }

    fun plusMoney(idx : Int, ticket_result: IntArray) : Int{
        if(idx == 0 && ticket_result[idx] > 0){
            return 5000 * ticket_result[idx]
        }else if(idx == 1 && ticket_result[idx] > 0){
            return 50000 * ticket_result[idx]
        }else if(idx == 2 && ticket_result[idx] > 0){
            return 1500000 * ticket_result[idx]
        }else if(idx == 3 && ticket_result[idx] > 0){
            return 2000000000 * ticket_result[idx]
        }else if(idx == 4 && ticket_result[idx] > 0){
            return 30000000 * ticket_result[idx]
        }
        return 0
    }
}