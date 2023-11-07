package lotto

import ui.UserInput

fun main() {
    LottoGenerator(money = UserInput.readMoney())
        .run {
            create()
            printAll()
            LottoResult()
                .calculateWinLottos(this.lottos)
                .showWinLottoData()
                .showProfitData(this.money)
        }
}
