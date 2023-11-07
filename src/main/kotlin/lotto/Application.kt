package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

fun null_check(i: String?): String{
    if (i == null){
        throw IllegalArgumentException("[ERROR] NULL")
    }
    return i
}

fun lottoMoney(): Int{
    val amount = try{
        val money = null_check(readLine()).toIntOrNull()
        if (money == null || money % 1000 != 0 || money == 0){
            throw IllegalArgumentException("[ERROR] 잘못된 입금액 입니다. 1000원 단위로 입금해주세요. Ex)8000, 11000")
        }
            money.div(1000)
    }catch(e: IllegalArgumentException){
        println("[ERROR] 잘못된 입금액 입니다. 1000원 단위로 입금해주세요. Ex)8000, 11000")

        lottoMoney()
    }
    return amount
}

fun lotto_dispenser(amount:Int): MutableList<Lotto>{
    var bought_lotto:MutableList<Lotto> = mutableListOf()
    for (i in 0 until amount){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
        bought_lotto.add(Lotto(numbers))
    }
    return bought_lotto
}

fun winInput(): MutableList<Int>{
    val win_number = try{
        val input_number:List<String> = null_check(readLine()).split(',')
        input_number_checker(input_number, 6)
        var output_number:MutableList<Int> = mutableListOf()
        for (i in input_number){
            output_number.add(numberChecker(i, output_number))
        }
        output_number.sort()
        output_number
    }catch(e: IllegalArgumentException){
        print("[ERROR] 1에서 45사이의 숫자 6개를 중복 없이 입력해주세요 Ex) 1,2,3,4,5,6\n")
        winInput()
    }
    return win_number
}
fun input_number_checker(i: List<String>, want_size: Int){
    if (i.size != want_size){
        throw IllegalArgumentException("[ERROR] 1에서 45사이의 \'숫자\'만 입력해주세요")
    }
}
fun numberChecker(i:String, numbs:MutableList<Int>): Int{
    val num:Int? = i.toIntOrNull()
    if (num == null || num >= 46 || num <= 0 || num in numbs){
        throw IllegalArgumentException("[ERROR] 1에서 45사이의 \'숫자\'만 입력해주세요")
    }
    return num
}

fun bonusChecker(checkList:MutableList<Int>):Int{
    val num = try{
        numberChecker(null_check(readLine()), checkList)
    }catch(e: IllegalArgumentException){
        println("[ERROR] 1에서 45사이의 숫자를 당첨번호와 중복없이 입력해주세요 (당첨번호: ${checkList})")
        bonusChecker(checkList)
    }
    return num
}

fun win_checker(bought: MutableList<Lotto>, winNum: MutableList<Int>, bonus: Int): Int{
    var winRate:MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0)
    for (i in bought){
        winRate[i.win_checker(winNum, bonus)] ++
    }
    println("3개 일치 (5,000원) - ${winRate[0]}개")
    println("4개 일치 (50,000원) - ${winRate[1]}개")
    println("5개 일치 (1,500,000원) - ${winRate[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winRate[3]}개")
    println("6개 일치 (2,000,000,000원) - ${winRate[4]}개")

    return (winRate[0] * 5000 + winRate[1] * 50000 + winRate[2] * 1500000 + winRate[3] * 30000000 + winRate[4] * 2000000000)
}

fun main() {
    println("구입금액을 입력해 주세요.")
    val amount:Int = lottoMoney()
    println("\n${amount}개를 구매했습니다.")
    val lottos:MutableList<Lotto> = lotto_dispenser(amount)
    println("\n당첨 번호를 입력해 주세요.")
    val win_num:MutableList<Int> = winInput()
    println("\n보너스 번호를 입력해 주세요.")
    val bonus:Int = bonusChecker(win_num)
    println("\n당첨 통계\n---")
    val won_money:Int = win_checker(lottos, win_num, bonus)
    val profit_rate:Double = round((won_money.toDouble().div(amount.toDouble() * 1000) * 100) * 10)
    println("총 수익률은 ${profit_rate/10}%입니다.")
}
