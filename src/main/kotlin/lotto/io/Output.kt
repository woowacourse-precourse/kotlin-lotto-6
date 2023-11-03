package lotto.io

class Output {
    fun printAmountMsg() {
        println("구입금액을 입력해 주세요.")
    }

    fun printQuantityMsg(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printWinningNumbersMsg() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumberMsg() {
        println("보너스 번호를 입력해 주세요.")
    }
}