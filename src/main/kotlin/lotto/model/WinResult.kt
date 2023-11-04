package lotto.model

class WinResult(private val user : User, private val winningLotto : WinningLotto) {
    private var _placeResult =  hashMapOf<Place,Int>()
    val placeResult get() = _placeResult
    private var _earningRate = 0.0
    val earningRate get() = _earningRate

    fun calculateResult(){
        for(lotto in user.lottoes){
           val place = compareLottoNumber(lotto,winningLotto)
            _placeResult[place] = _placeResult.getOrDefault(place, 0)+1
        }
    }
    private fun compareLottoNumber(lotto: Lotto , winningLotto: WinningLotto) : Place{
        val lottoNumbers = lotto.getLottoNumbers()
        val luckyNumbers = winningLotto.luckyNumbers
        val bonusNumber = winningLotto.bonusNumber
        val matchNumbers = lottoNumbers.count{lottoNumber -> lottoNumber in luckyNumbers}
        val matchBonus = lottoNumbers.contains(bonusNumber)
        return Place.decidePlace(matchNumbers,matchBonus)
    }

    fun calculateEarningRate(price : Int) : Double{
        var earnMoney = 0
        for(place in _placeResult){
            earnMoney += place.key.price * place.value
        }
        return (earnMoney / price.toDouble()) * 100
    }
}