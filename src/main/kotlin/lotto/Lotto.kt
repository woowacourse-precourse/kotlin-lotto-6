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
            println("\n보너스 번호를 입력해 주세요.")
            try {
                bonusNumber = getInput().toInt()
                checkBonusNumberValid(bonusNumber)
                println(bonusNumber)
                break
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자는 하나만 써주세요!!")
            } catch (e: IllegalArgumentException) {
                catchErrorMessageInGetBonusNumber(e)
            }
        }
    }

    private fun catchErrorMessageInGetBonusNumber(e: IllegalArgumentException) {
        when (e.message) {
            "중복 숫자 오류" -> println("[ERROR] 보너스가 중복입니다")
            "입력 범위 오류" -> println("[ERROR] 1 ~ 45 사이에 숫자만 써주세요")
        }
    }

    private fun checkBonusNumberValid(bonusNumber: Int) {
        checkLength(bonusNumber)
        checkBonusDuplicate(bonusNumber)
        numbers.add(bonusNumber)
    }

    private fun checkBonusDuplicate(bonusNumber: Int) {
        if (numbers.contains(bonusNumber)) {
            throw IllegalArgumentException("중복 숫자 오류")
        }
    }

    private fun checkLength(checkLengthNumber: Int) {
        if (checkLengthNumber !in 1..45) {
            throw IllegalArgumentException("입력 범위 오류")
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
        println("\n당첨 통계\n---")
        println("3개 일치 (5,000원) - ${lottoResult.threeContains.count()}개")
        println("4개 일치 (50,000원) - ${lottoResult.fourContains.count()}개")
        println("5개 일치 (1,500,000원) - ${lottoResult.fiveContains.count()}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResult.fiveBonusContains.count()}개")
        println("6개 일치 (2,000,000,000원) - ${lottoResult.sixContains.count()}개")
        print("총 수익률은 ${percentBenefit}%입니다.")
    }
}
