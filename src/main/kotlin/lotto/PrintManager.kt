package lotto

class PrintManager {
    fun inputMoney() = println(INPUT_MONEY_PROMPT)

    fun inputWinningNumber() = println(INPUT_WINNING_NUMBER_PROMPT)

    fun inputBonusNumber() = println(INPUT_BONUS_NUMBER_PROMPT)

    fun printLottoNumber(lottoNumber: Int) = println("\n${lottoNumber}${LOTTO_NUMBER_PROMPT}")

    fun printLotto(lottos: List<Lotto>) {
        lottos.forEach {lotto ->
            println(lotto)
        }
    }

    companion object {
        const val INPUT_MONEY_PROMPT = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBER_PROMPT = "\n당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해 주세요."
        const val LOTTO_NUMBER_PROMPT = "개를 구매했습니다."
    }
}