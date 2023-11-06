package lotto.service

import lotto.domain.*
import lotto.view.OutputView

class WinResultService(
    private val outputView: OutputView = OutputView()
) {


    private val placeResult = hashMapOf<Place, Int>()
    private var earningRate = 0.0

    fun makeWinResult(user: User, winningLotto: WinningLotto): WinResult {
        outputView.printWinStatisticsMessage()
        calculateResult(user, winningLotto)
        outputView.printWinStatisticsResult(placeResult)
        calculateEarningRate(user)
        outputView.printTotalEarningRate(earningRate)
        return WinResult(placeResult, earningRate)
    }


    private fun calculateResult(user: User, winningLotto: WinningLotto) {
        for (lotto in user.getLottoes()) {
            val place = compareLottoNumber(lotto, winningLotto)
            placeResult[place] = placeResult.getOrDefault(place, 0) + 1
        }
    }

    private fun compareLottoNumber(lotto: Lotto, winningLotto: WinningLotto): Place {
        val lottoNumbers = lotto.getLottoNumbers()
        val luckyNumbers = winningLotto.getWinningNumbers()
        val bonusNumber = winningLotto.getBonusNumber()
        val matchNumbers = lottoNumbers.count { lottoNumber -> lottoNumber in luckyNumbers }
        val matchBonus = lottoNumbers.contains(bonusNumber)
        return Place.decidePlace(matchNumbers, matchBonus)
    }

    private fun calculateEarningRate(user: User) {
        var earnMoney = 0
        for (place in placeResult) {
            earnMoney += place.key.price * place.value
        }
        earningRate = (earnMoney / user.getPrice().toDouble()) * 100
    }
}