package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round
import kotlin.math.roundToInt

class Lotto(val numbers: List<Int>) {
    // 작성순서 : 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체


    init {
        require(numbers.size == 6 && (numbers.size == numbers.distinct().size)) {
            try {
                throw IllegalArgumentException("미리 예외체크 했음에도 예외발생")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        testLottoBall6 = numbers
        randomBallVowel["${presentRound}"] = testLottoBall6
    }

    enum class Place(val text: String) {
        first("1등"),
        second("2등"),
        third("3등"),
        fourth("4등"),
        fifth("5등")
    }

    companion object {

        var inputResult = ""
        var randomBall6 = listOf<Int>()
        var randomBallVowel = mutableMapOf<String, List<Int>>()
        var presentRound = 0

        var testLottoBall6 = listOf<Int>()
        var selectBall6 = listOf<Int>()
        var selectBonusBall = 0

        var totalInventory = mutableMapOf<String, Int>()
        var investmentAmount = 0
        var Times = 0
        var totalMoney = 0

        var palce_1st = 0
        var palce_2nd = 0
        var palce_3rd = 0
        var palce_4th = 0
        var palce_5th = 0


        fun userInput(): String {
            inputResult = Console.readLine()
            return inputResult
        }

        fun getRandomBall(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }


        fun allDisplay() {
            for (clue in randomBallVowel.keys) {
                println("로또번호 ${clue} : ${randomBallVowel[clue]}")
            }
        }

        fun totalInventoryFillInit() {
            totalInventory[Place.first.text] = 0
            totalInventory[Place.second.text] = 0
            totalInventory[Place.third.text] = 0
            totalInventory[Place.fourth.text] = 0
            totalInventory[Place.fifth.text] = 0
        }

        fun placeTemporaryConversion() {
            // 해당 등수의 갯수를 가져오기위한 변수 임시변환
            palce_1st = totalInventory.getValue(Place.first.text)
            palce_2nd = totalInventory.getValue(Place.second.text)
            palce_3rd = totalInventory.getValue(Place.third.text)
            palce_4th = totalInventory.getValue(Place.fourth.text)
            palce_5th = totalInventory.getValue(Place.fifth.text)
        }

        fun numberContrast(
            randomBallVowel: MutableMap<String, List<Int>>,
            selectBall6: List<Int>,
            selectBonusBall: Int
        ): MutableMap<String, Int> {
            for (clue in randomBallVowel.keys) {
                var samAmount = (randomBallVowel[clue])!!.intersect(selectBall6).count()
                when (samAmount) {
                    3 -> palce_5th++
                    4 -> palce_4th++
                    6 -> palce_3rd++
                }
                if ((randomBallVowel.getValue(clue).contains(selectBonusBall)) && samAmount == 5) {
                    palce_2nd++
                }
                if (samAmount == 5) {
                    palce_1st++
                }
            }
            return totalInventory
        }

        fun tatisticsDisplay() {
            println("3개 일치 (5,000원) - ${palce_5th}개")
            println("4개 일치 (50,000원) - ${palce_4th}개")
            println("5개 일치 (1,500,000원) - ${palce_3rd}개")
            println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${palce_2nd}개")
            println("6개 일치 (2,000,000,000원) - ${palce_1st}개")
            totalMoney = (5000 * palce_5th) + (5000 * palce_4th) + (1500000 * palce_3rd)
            +(30000000 * palce_2nd) + (2000000000 * palce_1st)

            println("투자금 : ${investmentAmount}")
            println("수익금 : ${totalMoney.toDouble()}")
            println("결과값 : ${totalMoney.toDouble().div(investmentAmount)}")
            var decimalNumber = totalMoney.toDouble().div(investmentAmount) * 100
            var returnRate = String.format("%.1f", decimalNumber)
            println("총 수익률은 ${returnRate}%입니다.")
        }
    }
}

