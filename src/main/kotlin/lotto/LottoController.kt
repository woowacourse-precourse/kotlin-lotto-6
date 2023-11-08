package lotto

import lotto.dto.CostDto
import lotto.dto.PurchasedLottoDto
import lotto.exception.DuplicatedNumberException
import lotto.exception.NotPositiveCostException
import lotto.exception.UnvalidCostException
import lotto.exception.UnvalidLottoNumberException
import lotto.model.BonusNumber
import lotto.model.Cost
import lotto.model.Lotto
import lotto.model.PurchasedLottoCollection
import lotto.utility.Utils
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
        lotto = Lotto(inputView.inputLottoNumbers())
    }

    fun getBonuseNumber() {
        bonusNumber = BonusNumber(inputView.inputBonusNumber(lotto.getLottoNumbers()))
    }

    fun setPurchasedLottoService() {
        purchasedLottoService = PurchasedLottoService(cost.getLottoCount())
    }
}