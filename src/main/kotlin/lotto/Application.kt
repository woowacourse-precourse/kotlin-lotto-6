package lotto

import ui.UserInput

fun main() {
    val lottoGenerator = LottoGenerator(money = UserInput.readMoney())

    lottoGenerator
        .create()
        .printLotto()

    val lottoResult = LottoResult()

    lottoResult
        .calculateWinLottos(lottoGenerator.lottos)
        .showWinLottoData()
        .showProfitData(lottoGenerator.money)
}
