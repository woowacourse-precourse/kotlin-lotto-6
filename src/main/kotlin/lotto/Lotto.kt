package lotto

class Lotto(private val numbers: List<Int>) { // 사용자 넘버
    init {
        require(numbers.size == 6)
    }

    val app = lottoGame.RESULT
    val realNumbers = app.realLottoNumbers
    var winningCount = app.winningCount
    val winningProbability = app.winningProbability

    fun startAnaylze() {
        val equals = countEquals()
        countResult(equals)
    }

    fun printResult() {
        getProbability()
        println(Utils.RESULT_MESAGE)
        println("${Utils.FIFTH_PLACE}+${winningCount[4]}+${Utils.PLACE_END_MESSAGE}")
        println("${Utils.FOURTH_PLACE}+${winningCount[3]}+${Utils.PLACE_END_MESSAGE}")
        println("${Utils.THIRD_PLACE}+${winningCount[2]}+${Utils.PLACE_END_MESSAGE}")
        println("${Utils.SECOND_PLACE}+${winningCount[1]}+${Utils.PLACE_END_MESSAGE}")
        println("${Utils.FIRST_PLACE}+${winningCount[0]}+${Utils.PLACE_END_MESSAGE}")
        println("${Utils.ROI_PERCENTAGE}+${winningProbability[0]}+${Utils.ROI_END_MESSAGE}")
    }
    fun getProbability() {
        var sumTotal = 0
        val money = listOf(2000000000, 30000000, 1500000, 50000, 5000)
        winningCount.forEachIndexed { index, count ->
            sumTotal += count*money[index]
        }
        winningProbability.add(sumTotal/winningProbability[0])
    }

    fun countResult(equals: Int) {
        when(equals%10) {
            6 -> winningCount[0]++
            5 -> {
                if(equals/10==1)
                    winningCount[1]++
                else
                    winningCount[2]++
            }
            4 -> winningCount[3]++
            3 -> winningCount[4]++
        }
    }

    fun countEquals(): Int {
        var equalCount = 0
        var bonusCount = 0
        realNumbers.forEachIndexed { index, realNumber ->
            if(numbers.contains(realNumber) && index != 6)
                equalCount++
        }
        if(numbers.contains(realNumbers[6]))
            bonusCount++

        return bonusCount*10+equalCount
    }
}
