package lotto

import ui.UserInput
import ui.UserOutput

fun main() {
    val lottoGenerator = LottoGenerator(money = UserInput.readMoney())
    lottoGenerator
        .create()
        .printLotto()

    val lottoResult = LottoResult(
        winLotto = Lotto(UserInput.readWinNumbers()),
        bonus = UserInput.readBonusNumber()
    )
    lottoResult
        .calculateWinLottos(lottoGenerator.lottos)
        .showWinLottoData()

}
