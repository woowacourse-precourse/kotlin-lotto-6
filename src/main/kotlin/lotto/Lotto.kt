package lotto

import camp.nextstep.edu.missionutils.Console


class Lotto(private val numbers: MutableList<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == numbers.size)
        require(numbers.all { it in 1..45 })
    }

    private fun getInput(): String {
        return Console.readLine()
    }

    fun getBonusNumber() {
        var bonusNumber: Int
        while (true) {
            println(Constant.BONUS_INPUT)
            try {
                bonusNumber = getInput().toInt()
                checkBonusNumberValid(bonusNumber)
                println(bonusNumber)
                break
            } catch (e: NumberFormatException) {
                println(Constant.ONE_NUMBER_ERROR_MESSAGE)
            } catch (e: IllegalArgumentException) {
                catchErrorMessageInGetBonusNumber(e)
            }
        }
    }

    private fun catchErrorMessageInGetBonusNumber(e: IllegalArgumentException) {
        when (e.message) {
            Constant.DUPLICATE_ERROR -> println(Constant.BONUS_DUPLICATE_ERROR_MESSAGE)
            Constant.INPUT_SIZE_ERROR -> println(Constant.RANGE_ERROR_MESSAGE)
        }
    }

    private fun checkBonusNumberValid(bonusNumber: Int) {
        checkLength(bonusNumber)
        checkBonusDuplicate(bonusNumber)
        numbers.add(bonusNumber)
    }

    private fun checkBonusDuplicate(bonusNumber: Int) {
        if (numbers.contains(bonusNumber)) {
            throw IllegalArgumentException(Constant.DUPLICATE_ERROR)
        }
    }

    private fun checkLength(checkLengthNumber: Int) {
        if (checkLengthNumber !in 1..45) {
            throw IllegalArgumentException(Constant.INPUT_SIZE_ERROR)
        }
    }

    fun printLottoNumbers() {
        println(numbers)
    }

    fun lottoLogic(lottoList: MutableList<List<Int>>, price: Int) {
        val lottoResult = LottoResult()
        for (lotto in lottoList) {
            val tempLotto = lotto.subList(0, 6)
            val count = tempLotto.count { it in numbers }
            if (count == 5 && lotto.last() == numbers.last()) {
                lottoResult.fiveBonusContains.add(lotto)
            } else {
                classifyLottoResults(lotto, count, lottoResult)
            }
        }
        printResult(lottoResult, getPercentBenefit(price, lottoResult))
    }

    private fun classifyLottoResults(lotto: List<Int>, count: Int, lottoResult: LottoResult) {
        when (count) {
            LottoResultType.THREE_MATCH.count -> lottoResult.threeContains.add(lotto)
            LottoResultType.FOUR_MATCH.count -> lottoResult.fourContains.add(lotto)
            LottoResultType.FIVE_MATCH.count -> lottoResult.fiveContains.add(lotto)
            LottoResultType.SIX_MATCH.count -> lottoResult.sixContains.add(lotto)
        }
    }

    private fun getPercentBenefit(price: Int, lottoResult: LottoResult): Float {
        val totalBenefit = lottoResult.threeContains.count() * LottoPrize.THREE_MATCH.prizeAmount +
                        lottoResult.fourContains.count() * LottoPrize.FOUR_MATCH.prizeAmount +
                        lottoResult.fiveContains.count() * LottoPrize.FIVE_MATCH.prizeAmount +
                        lottoResult.fiveBonusContains.count() * LottoPrize.FIVE_BONUS_MATCH.prizeAmount +
                        lottoResult.sixContains.count() * LottoPrize.SIX_MATCH.prizeAmount
        return (totalBenefit / price) * 100f
    }

    private fun printResult(lottoResult: LottoResult, percentBenefit: Float) {
        println(Constant.RESULT)
        println("${Constant.THREE_MATCH}${lottoResult.threeContains.count()}${Constant.AMOUNT}")
        println("${Constant.FOUR_MATCH}${lottoResult.fourContains.count()}${Constant.AMOUNT}")
        println("${Constant.FIVE_MATCH}${lottoResult.fiveContains.count()}${Constant.AMOUNT}")
        println("${Constant.FIVE_BONUS}${lottoResult.fiveBonusContains.count()}${Constant.AMOUNT}")
        println("${Constant.SIX_MATCH}${lottoResult.sixContains.count()}${Constant.AMOUNT}")
        print("${Constant.TOTAL_PRIZE}${percentBenefit}${Constant.PERCENT}")
    }
}
