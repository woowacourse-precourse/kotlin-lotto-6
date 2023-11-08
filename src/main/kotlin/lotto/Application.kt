package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val ammount = lotto_pay()
    Lottogenerator(ammount)
    val winningnum = lotto_input()
    print(winningnum)

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


