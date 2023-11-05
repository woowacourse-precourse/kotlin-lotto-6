package lotto.model

class LottoResultAnalyzer {
    val analyzedLottoResults: List<Int>
        get() = _analyzedLottoResults
    private var _analyzedLottoResults = MutableList<Int>(5){0}

    fun analyzeLottoResults(result: List<Int>){
        result.forEach {
            when (it) {
                3 -> _analyzedLottoResults[0]++
                4 -> _analyzedLottoResults[1]++
                5 -> _analyzedLottoResults[2]++
                6 -> _analyzedLottoResults[3]++
                100 -> _analyzedLottoResults[4]++
            }
        }
    }
}