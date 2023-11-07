package lotto

import camp.nextstep.edu.missionutils.Console

class View {
    private val validation = Validation()

    fun printInputPaymentMessage(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return validation.checkInputPayment(input)
    }

    fun printInputLottoNumber(): Lotto {
        println("\n당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        return validation.checkInputLottoNumber(input)
    }

    fun printLotto(lotto: List<Lotto>) {
        println("\n${lotto.size}개를 구매했습니다.")
        lotto.forEach {
            println(it.getLottoNumbers())
        }
    }
}
