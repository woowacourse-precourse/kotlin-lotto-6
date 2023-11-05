package lotto

import ui.UserInput
import ui.UserOutput

fun main() {
    val lottoGenerator = LottoGenerator(UserInput.readMoney())
    lottoGenerator.create()

    UserOutput.printPurchaseResult(lottoGenerator.lottos.size)
    for (lotto in lottoGenerator.lottos) println(lotto.toAscendingList())

    val lottoResult = LottoResult().apply {
        this.winLotto = Lotto(UserInput.readWinNumbers())
        this.bonus = UserInput.readBonusNumber()
    }


}
