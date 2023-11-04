package lotto.model

class WinResult(private val user : User, private val winningLotto : WinningLotto) {
    private var _placeResult =  hashMapOf<Place,Int>()
    val placeResult get() = _placeResult


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
}