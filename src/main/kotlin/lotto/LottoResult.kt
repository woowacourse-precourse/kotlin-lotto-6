package lotto

import lotto.LottoData.lottoNumber
import lotto.LottoMessage.FIFTH_PLACE
import lotto.LottoMessage.FIRST_PLACE
import lotto.LottoMessage.FOURTH_PLACE
import lotto.LottoMessage.LINE_BREAK
import lotto.LottoMessage.LOTTO_RESULT
import lotto.LottoMessage.RATE_OF_RETURN
import lotto.LottoMessage.SECOND_PLACE
import lotto.LottoMessage.THIRD_PLACE

object LottoResult {
    val placeList = mutableListOf(0, 0, 0, 0, 0)//6개 맞춤,5개+보너스,5개,4개.3개
    val rewardList = listOf(2000000000, 30000000, 1500000, 50000, 5000)//1등:6개 맞춤

    fun showResult() {
        println(LOTTO_RESULT)
        println(LINE_BREAK)
        doCountCommonNumbers()

        setResult(placeList)
    }


    // TODO 내 당첨 번호랑, 구매한 로또들과 비교하기

    fun countCommonNumbers(list1: List<Int>, list2: List<Int>): Int {
        val commonElements = list1.intersect(list2.toSet())

        return commonElements.size
    }

    fun doCountCommonNumbers() {
        val myLotto = LottoData.myLottoNumber
        //println(myLotto)
        lateinit var lottoList: List<Int>
        val myBonusNumber = LottoData.myBonusNumber

        for (lotto in lottoNumber) {
            lottoList = lotto
            val count = countCommonNumbers(myLotto, lottoList)
            if (count == 5) getPlace(bonusNumberIncentive(myBonusNumber, lotto))
            else getPlace(count)
            //println("두 리스트의 공통 요소의 개수: $count")
        }

    }

    fun bonusNumberIncentive(bonusNumber: Int, lotto: List<Int>): Int {
        return if (bonusNumber in lotto) 10 else 5
    }

    fun getPlace(commonNumberCount: Int) {
        when (commonNumberCount) {
            LottoStatus.SIX.count -> placeList[0]++
            LottoStatus.FIVE_WITH_BONUS.count -> placeList[1]++
            LottoStatus.FIVE.count -> placeList[2]++
            LottoStatus.FOUR.count -> placeList[3]++
            LottoStatus.THREE.count -> placeList[4]++
        }
    }

    fun setResult(numberList: List<Int>) {
        val firstPlaceMessage = FIRST_PLACE.format(numberList[0])
        val secondPlaceMessage = SECOND_PLACE.format(numberList[1])
        val thirdPlaceMessage = THIRD_PLACE.format(numberList[2])
        val fourthPlaceMessage = FOURTH_PLACE.format(numberList[3])
        val fifthPlaceMessage = FIFTH_PLACE.format(numberList[4])

        println(fifthPlaceMessage)
        println(fourthPlaceMessage)
        println(thirdPlaceMessage)
        println(secondPlaceMessage)
        println(firstPlaceMessage)

        calculateReward(numberList, rewardList)
    }

    fun calculateReward(numberList: List<Int>, rewardList: List<Int>) {
        val moneySpent = LottoData.purchasePrice
        var moneyWon = 0

        for (i in numberList.indices) {
            when (numberList[i]) {
                0 -> {}
                else -> {
                    moneyWon += numberList[i] * rewardList[i]
                }
            }
        }

        val finalRateOfReturn: Double = (moneyWon.toDouble() / moneySpent.toDouble()) * 100.0
        val finalResult = RATE_OF_RETURN.format(finalRateOfReturn)

        println(finalResult)
    }
}