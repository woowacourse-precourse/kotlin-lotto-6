package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val ammount = lotto_pay()
    val lottos = Lottogenerator(ammount)
    val winningnum = lotto_input()
    print(winningnum)
    val bonusnum = lotto_input_bonus()
    print(bonusnum)
    cal_lotto(lottos,winningnum,bonusnum)

}
fun lotto_pay() : Int//로또 구입 금액을 받아 처리하는 `lotto_pay`
{

    while (true) {
        try {
            print("구입 금액을 입력해 주세요: ")
            val input = Console.readLine()?.toInt() ?: throw IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.")
            if (input % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.")
            }
            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
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
            print("보너스 번호를 입력해 주세요: ")
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
fun cal_lotto(Lottos: List<Lotto>, winningnum : List<Int>, bonusnum : Int) : Map<String,Int> //당첨 여부를 연산하는 `cal_lotto` 메서드
{
    val status = mutableMapOf(
        "3개 일치" to 0,
        "4개 일치" to 0,
        "5개 일치" to 0,
        "5개 일치, 보너스 볼 일치" to 0,
        "6개 일치" to 0
    )
    for (lotto in Lottos) {
        val matchingNumbers = lotto.getlottonum().intersect(winningnum).size // 교집합으로 일치하는 숫자 검사
        if (matchingNumbers == 6) {
            status["6개 일치"] = status["6개 일치"]!! + 1
        } else if (matchingNumbers == 5 && lotto.getlottonum().contains(bonusnum)) {
            status["5개 일치, 보너스 볼 일치"] = status["5개 일치, 보너스 볼 일치"]!! + 1
        } else {
            status["$matchingNumbers 개 일치"] = status["$matchingNumbers 개 일치"]!! + 1
        }
    }
    return status
}


