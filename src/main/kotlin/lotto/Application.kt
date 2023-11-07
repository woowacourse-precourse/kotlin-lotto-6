package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

fun lottoMoney(): Int{
    val moneyinput: String? = readLine()
    requireNotNull(moneyinput){"[ERROR"}
    val money:Int? = moneyinput.toIntOrNull()
    require(money != null && money != 0 && money % 1000 == 0){"[ERROR"}
    return money.div(1000)
}

fun lotto_dispenser(money: Int): MutableList<Lotto>{
    var lottos: MutableList<Lotto>  = mutableListOf()
    for (i in 0 until money){
        var auto_number = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        auto_number.sort()
        lottos.add(Lotto(auto_number))
    }
    return lottos
}

fun winInput(): MutableList<Int>{
    var win_number:MutableList<Int> = mutableListOf<Int>()
    val input_number:List<String> = requireNotNull(readLine()).split(',')
    for (i in input_number){
        val num = requireNotNull(i.toIntOrNull()){"[ERROR]"}
        require(num >= 1 && num <= 45)
        win_number.add(num)
    }
    require(input_number.distinct().size == 6){"[ERROR]"}
    return win_number
}

fun bonusChecker(win_num:MutableList<Int>): Int{
    val input_bonus:Int? = requireNotNull(readLine()){"[ERROR]"}.toIntOrNull()
    require(input_bonus != null && input_bonus !in win_num)
    return input_bonus
}

fun win_checker(lottos: MutableList<Lotto>, win_num: MutableList<Int>, bonus: Int): Int{
    var winRate:MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0)
    for (i in lottos){
        winRate[i.win_checker(win_num, bonus)] ++
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
    val money:Int = lottoMoney()
    println("\n${money}개를 구매했습니다.")
    val lottos: MutableList<Lotto> = lotto_dispenser(money)
    println("\n당첨 번호를 입력해 주세요.")
    val win_num: MutableList<Int> = winInput()
    println("\n보너스 번호를 입력해 주세요.")
    val bonus: Int = bonusChecker(win_num)
    println("\n당첨 통계\n---")
    val won_money: Int = win_checker(lottos, win_num, bonus)
    val profit_rate: Double = round((won_money.toDouble().div(money.toDouble() * 1000) * 100) * 10)
    println("총 수익률은 ${profit_rate / 10}%입니다.")
}
