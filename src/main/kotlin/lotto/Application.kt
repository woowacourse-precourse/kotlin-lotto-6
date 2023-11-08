package lotto

import camp.nextstep.edu.missionutils.Console
import java.text.NumberFormat
import kotlin.math.roundToInt

fun main() {
    val ammount = lotto_pay()
    val lottos = Lottogenerator(ammount)
    val winningnum = lotto_input()
    val bonusnum = lotto_input_bonus()
    val status = cal_lotto(lottos,winningnum,bonusnum)
    print_lotto(status,lottos)

}
fun lotto_pay() : Int//로또 구입 금액을 받아 처리하는 `lotto_pay`
{

    while (true) {
        try {
            println("구입 금액을 입력해 주세요: ")
            val tmp =  Console.readLine()?: throw IllegalArgumentException("[ERROR]")

            val input = tmp.toInt()
            if (input % 1000 != 0 ||  tmp.contains(Regex(".*[a-zA-Z].*"))) {
                throw IllegalArgumentException("[ERROR]")
            }
            return input
        } catch (e: IllegalArgumentException) {
            println("[ERROR]"+e.message)
        }
    }
}

fun lotto_input() : List<Int>//당첨 번호를 입력 받는 `lotto_input`
{
    while (true) {
        try {
            println("당첨 번호를 입력해 주세요.")
            val input = Console.readLine()?.split(',')?.map { it.trim().toInt() } ?: throw IllegalArgumentException("[ERROR] 로또 번호를 입력해 주세요.")
            if (input.size != 6 || input.any { it < 1 || it > 45 }) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

}
fun lotto_input_bonus() : Int // 보너스 번호를 입력받는 lotto_input_bonus
{
    while (true) {
        try {
            println("보너스 번호를 입력해 주세요: ")
            val input = Console.readLine()?.toInt() ?: throw IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.")
            if (input < 1 || input > 45) {
                throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
fun Lottogenerator(ammount : Int) :List<Lotto>//사용자 입력 횟수만큼 로또 번호를 생성해주는 `Lottogenerator`
{
    val lottoammount = ammount / 1000
    val lottos = mutableListOf<Lotto>()
    for(i in 1..lottoammount){
        lottos.add(Lotto.createLottoNumber())
    }

    lotto_numbers_print(lottos)

    return lottos
}
fun lotto_numbers_print( Lottos : List<Lotto>)//로또 번호 생성 결과를 출력해주는 `lotto_numbers_print`
{
    println("${Lottos.size}개를 구매했습니다.")
    for(lotto in Lottos)
    {
        val numbers = lotto.getlottonum().sorted()
        println(numbers)
    }
}
fun cal_lotto(Lottos: List<Lotto>, winningnum: List<Int>, bonusnum: Int): Map<String, Int> {
    val status = mutableMapOf(
        "3개 일치" to 0,
        "4개 일치" to 0,
        "5개 일치" to 0,
        "5개 일치, 보너스 볼 일치" to 0,
        "6개 일치" to 0
    )

    for (lotto in Lottos) {
        val matchingNumbers = lotto.getlottonum().intersect(winningnum).size
        when (matchingNumbers) {
            6 -> status["6개 일치"] = status.getOrDefault("6개 일치", 0) + 1
            5 -> if (lotto.getlottonum().contains(bonusnum)) {
                status["5개 일치, 보너스 볼 일치"] = status.getOrDefault("5개 일치, 보너스 볼 일치", 0) + 1
            } else {
                status["5개 일치"] = status.getOrDefault("5개 일치", 0) + 1
            }
            4 -> status["4개 일치"] = status.getOrDefault("4개 일치", 0) + 1
            3 -> status["3개 일치"] = status.getOrDefault("3개 일치", 0) + 1
        }
    }
    return status
}

fun print_lotto(status: Map<String, Int>, lottos: List<Lotto>) {
    println("당첨 통계")
    println("---")
    val prizeMoney = mapOf(
        "3개 일치" to 5_000,
        "4개 일치" to 50_000,
        "5개 일치" to 1_500_000,
        "5개 일치, 보너스 볼 일치" to 30_000_000,
        "6개 일치" to 2_000_000_000
    )

    var totalPrize = 0
    val numberFormat = NumberFormat.getNumberInstance()

    for ((key, value) in status) {
        val prize = prizeMoney[key] ?: 0
        val total = prize * value
        totalPrize += total
        println("$key (${numberFormat.format(prize)}원) - ${value}개")
    }

    val prizePerTicket = 1_000 // 1장당 가격
    val totalSpent = lottos.size * prizePerTicket
    val profitRate = if (totalSpent == 0) 0.0 else ((totalPrize).toDouble() / totalSpent.toDouble()) * 100.0
    val roundedProfitRate = (profitRate * 10.0).roundToInt() / 10.0
    println("총 수익률은 ${"%.1f".format(roundedProfitRate)}%입니다.")
}





