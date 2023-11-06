package lotto.service

import lotto.domain.*

class WinResultService {

    fun makeWinResult(user: User, winningLotto: WinningLotto): WinResult {
        val placeResult = calculateResult(user, winningLotto)
        val earningRate = calculateEarningRate(user, placeResult)
        return WinResult(placeResult, earningRate)
    }


    private fun calculateResult(user: User, winningLotto: WinningLotto): HashMap<Place, Int> {
        val placeResult = hashMapOf<Place, Int>()
        for (lotto in user.getLottoes()) {
            val place = compareLottoNumber(lotto, winningLotto)
            placeResult[place] = placeResult.getOrDefault(place, 0) + 1
        }
        return placeResult
    }

    private fun compareLottoNumber(lotto: Lotto, winningLotto: WinningLotto): Place {
        val lottoNumbers = lotto.getLottoNumbers()
        val luckyNumbers = winningLotto.getWinningNumbers()
        val bonusNumber = winningLotto.getBonusNumber()
        val matchNumbers = lottoNumbers.count { lottoNumber -> lottoNumber in luckyNumbers }
        val matchBonus = lottoNumbers.contains(bonusNumber)
        return Place.decidePlace(matchNumbers, matchBonus)
    }

    private fun calculateEarningRate(user: User, placeResult: HashMap<Place, Int>): Double {
        var earningRate = 0.0
        var earnMoney = 0
        for (place in placeResult) {
            earnMoney += place.key.price * place.value
        }
        earningRate = (earnMoney / user.getPrice().toDouble()) * 100
        return earningRate
    }
}