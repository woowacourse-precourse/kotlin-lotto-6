package lotto

import ui.UserInput
import ui.UserOutput

fun main() {
    val lottoGenerator = LottoGenerator(UserInput.readMoney())
    val lottos = lottoGenerator.create()

    UserOutput.printPurchaseResult(lottos.size)
    for (lotto in lottos) println(lotto.toAscendingList())

    val lottoResult = LottoResult().apply {
        this.lottos = lottos
        this.winLotto = Lotto(UserInput.readWinNumbers())
        this.bonus = UserInput.readBonusNumber()
    }


}
