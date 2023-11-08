package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val ammount = lotto_pay()
    Lottogenerator(ammount)

}
fun lotto_pay() : Int {

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
fun Lottogenerator(ammount : Int) :List<Lotto>
{
    val lottoammount = ammount / 1000
    val lottos = mutableListOf<Lotto>()
    for(i in 1..lottoammount){
        lottos.add(Lotto.createLottoNumber())
    }

    lotto_numbers_print(lottos)

    return lottos
}
fun lotto_numbers_print( Lottos : List<Lotto>)
{
    println("${Lottos.size}개를 구매했습니다.")
    for(lotto in Lottos)
    {
        val numbers = lotto.getlottonum().sorted()
        println(numbers)
    }
}

