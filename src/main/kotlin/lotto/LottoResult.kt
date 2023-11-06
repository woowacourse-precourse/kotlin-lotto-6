package lotto

class LottoResult() {
    fun calculateResult(lottoLists: List<List<Int>>, lottoNumber: List<Int>, bonusNumber: Int): MutableList<Int> {
        val resultList = MutableList(8) { 0 }
        val lottoSize = lottoLists.size
        for (i in 0 until lottoSize) {
            val result = calculateResultOnce(lottoLists[i], lottoNumber, bonusNumber)
            if (result[0] == Constant.LOTTO_NUMBER_SIZE) {
                resultList[7]++
            } else if (result[0] == 5 && result[1] == 1) {
                resultList[6]++
            } else {
                resultList[result[0]] += 1
            }
        }
        return resultList
    }

    private fun calculateResultOnce(lottoList: List<Int>, lottoNumber: List<Int>, bonusNumber: Int): List<Int> {
        var count = 0
        var flag = 0
        for (element in lottoList) {
            if (lottoNumber.contains(element)) {
                count += 1
            }
        }
        if (lottoList.contains(bonusNumber)) {
            count += 1
            flag = 1
        }
        return listOf(count, flag)
    }

    fun calculateTotalPrize(lottoResult: List<Int>): Long {
        val prizeMap = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 30000000,
            7 to 2000000000
        )
        var totalPrize = 0L
        for (i in 3..7) {
            totalPrize += lottoResult[i] * prizeMap[i]!!
        }
        return totalPrize
    }
}