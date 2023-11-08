package lotto

import lotto.view.InputView
import lotto.view.OutputView
import camp.nextstep.edu.missionutils.Randoms

class LottoController(private val inputview: InputView = InputView(),
                      private val outputview: OutputView = OutputView()) {
    init {
        val amount: Int = getAmount()
        var lottos: MutableList<Lotto> = mutableListOf()
        for (i in 1..amount) {
            lottos.add(buyLotto())
        }
        outputview.printPurchase(amount, lottos)

    }
    private fun getAmount(): Int {
        var amount: Int
        while(true) {
            try{
                outputview.amountMessage()
                amount = inputview.inputAmount()
                return amount
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    private fun buyLotto(): Lotto{
        val nums: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(nums.sorted())
    }

}