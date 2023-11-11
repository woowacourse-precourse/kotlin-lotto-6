package lotto

import lotto.dto.CostDto
import lotto.exception.DuplicatedNumberException
import lotto.model.BonusNumber
import lotto.model.Cost
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    val inputView = InputView()
    val outputView = OutputView()
    lateinit var purchasedLottoService : PurchasedLottoService
    lateinit var cost : Cost
    lateinit var lotto : Lotto
    lateinit var bonusNumber : BonusNumber


    fun lotto() {
        getCost()
        setPurchasedLottoService()
        outputView.printPurchasedLottoNumber(cost.getLottoCount())
        outputView.printAllPurchasedLotto(purchasedLottoService.getPurchasedLottoDtoList())
        getLottoNumber()
        getBonuseNumber()
        purchasedLottoService.setPurchsedLottoCollection(lotto.getLottoNumbers(), bonusNumber.getBonusNumber())
        outputView.printWinningResult(purchasedLottoService.getWinStatics())
        outputView.printRateOfReturn(purchasedLottoService.calculateRateOfReturn(CostDto(cost.getCost())))
    }

    fun getCost() {
        cost = Cost(inputView.inputCost())
    }

    fun getLottoNumber() {
        try {
            lotto = Lotto(inputView.inputLottoNumbers())
        } catch (error: DuplicatedNumberException) {
            println(error.message)
        }
    }

    fun getBonuseNumber() {
        bonusNumber = BonusNumber(inputView.inputBonusNumber(lotto.getLottoNumbers()))
    }

    fun setPurchasedLottoService() {
        purchasedLottoService = PurchasedLottoService(cost.getLottoCount())
    }
}