package lotto

import ui.UserInput

fun main() {
    LottoGenerator(money = UserInput.readMoney())
        .run {
            create()
            printAll()

            LottoResult().calculateWinLottos(this.lottos)
                .LottoResultShow(this.money) // inner class 생성
                .run {
                    showWinLottoData()
                    showProfitData()
                }
        }
}
