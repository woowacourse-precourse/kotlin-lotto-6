package lotto

class LottoResult() {
    fun calculateResult(lottoLists: List<List<Int>>, lottoNumber: List<Int>, bonusNumber: Int): MutableList<Int> {
        val resultList = MutableList(8) { 0 }
        val lottoSize = lottoLists.size
        for (i in 0 until lottoSize) {
            val result = calculateResultOnce(lottoLists[i], lottoNumber, bonusNumber)
            if (result[0] == 6) {
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
}