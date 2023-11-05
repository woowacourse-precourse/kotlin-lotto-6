package lotto.model

class LottoResultAnalyzer {
    private val analyzedLottoResults = MutableList(5) { 0 }

    fun analyzeLottoResults(result: List<Int>) {
        result.forEach { analyzeNumber(it) }
    }

    private fun analyzeNumber(number: Int) {
        when (number) {
            3 -> analyzedLottoResults[0]++
            4 -> analyzedLottoResults[1]++
            5 -> analyzedLottoResults[2]++
            100 -> analyzedLottoResults[3]++
            6 -> analyzedLottoResults[4]++
        }
    }

    fun getAnalyzedLottoResults(): List<Int> {
        return analyzedLottoResults.toList()
    }
}