package lotto

import ui.UserInput
import ui.UserOutput

fun main() {
    val lottoGenerator = LottoGenerator(UserInput.readMoney())
    val lottos = lottoGenerator.create()

    UserOutput.printPurchaseResult(lottos.size)
    for (lotto in lottos) println(lotto.toAscendingList())

    val lottoResult = LottoResult(lottos)
    lottoResult.winLotto = Lotto(UserInput.readWinNumbers())
    lottoResult.bonus = UserInput.readBonusNumber()

}
