package lotto

import lotto.LottoController
import lotto.ScreenView
class LottoGame {
    private val view  = ScreenView()
    private val controller = LottoController(view = view)
    fun run() {
        // 로또 구입 금액을 입력 받는다.
        val lottoQuantity = view.inputMoney()
        val boughtLottos = controller.buyLottos(lottoQuantity)

        // 발행한 로또 수량 및 번호를 출력한다.
        boughtLottos.print()

        // 당첨 번호를 입력 받는다.
        val answerLotto = view.inputLotto()
        if (controller.isNumRepeated(answerLotto)) {
            throw IllegalArgumentException("중복되는 숫자가 존재합니다.")
        }

        // 보너스 번호를 입력 받는다.
        val bonusNum = view.inputBonusNum()

        //
        val result = LottoResult()
        controller.countWinningNums(boughtLottos, answerLotto, bonusNum, result)
        controller.calculateRateOfReturn(result, lottoQuantity*1000)

        // 당첨 내역을 출력한다.
        view.printWinningStatistics(result)

    }
}