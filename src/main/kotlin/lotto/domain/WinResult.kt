package lotto.domain

class WinResult(private val placeResult: HashMap<Place, Int>, private val earningRate: Double) {

    fun getPlaceResult() = placeResult
    fun getEarningRate() = earningRate
}