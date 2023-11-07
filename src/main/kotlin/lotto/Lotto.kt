package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(val numbers: List<Int>) {
    // 작성순서 : 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체

    init {
        require(numbers.size == 6)
        numbersVowel["${Lotto.round}"] = numbers
    }

    enum class Place(val numberPlace: String, var amount: Int) {
        firstPlace("1등", 0),
        secondPlaece("2등", 0),
        thirdPlce("3등", 0),
        fourthPlace("4등", 0),
        fifthPlace("5등", 0)
    }

    companion object {
        var numbersVowel = mutableMapOf<String, List<Int>>()
        var inputResult = ""
        var SelectBall6 = listOf<Int>()
        var round = 0
        var totalMoney = 0
        var totalInventory = mutableMapOf<String, Int>()
        var InvestmentAmount = 0
        var Times = 0
        var lastBall7 = mutableListOf<String>()

        fun userInput(): String {
            Lotto.inputResult = Console.readLine()
            return Lotto.inputResult
        }

        fun SelectBall(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }

        fun allDisplay() {
            for (key in numbersVowel.keys) {
                println("로또번호 ${key} : ${numbersVowel[key]}")
            }
        }

        fun contrastNumber(numbersVowel:MutableMap<String, List<Int>>): MutableMap<String, Int> {
            return totalInventory
        }

        fun tatisticsDisplay(totalInventory: MutableMap<String, Int>, lastBall7:MutableList<String>
            , InvestmentAmount: Int) {
            Place.fifthPlace.amount =
                totalInventory[Place.fifthPlace.numberPlace].toString().toInt()
            println("3개 일치 (5,000원) - ${Place.fifthPlace.amount}개")
            Place.fourthPlace.amount =
                totalInventory[Place.fourthPlace.numberPlace].toString().toInt()
            println("4개 일치 (50,000원) - ${Place.fourthPlace.amount}개")
            Place.thirdPlce.amount = totalInventory[Place.thirdPlce.numberPlace].toString().toInt()
            println("5개 일치 (1,500,000원) - ${Place.thirdPlce.amount}개")
            Place.secondPlaece.amount =
                totalInventory[Place.secondPlaece.numberPlace].toString().toInt()
            println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${Place.secondPlaece.amount}개")
            Place.firstPlace.amount =
                totalInventory[Place.firstPlace.numberPlace].toString().toInt()
            println("6개 일치 (2,000,000,000원) - ${Place.firstPlace.amount}개")
            totalMoney = (5000 * Place.fifthPlace.amount) + (5000 * Place.fourthPlace.amount)
            +(1500000 * Place.thirdPlce.amount) + (30000000 * Place.secondPlaece.amount)
           /* +(2000000000 * Place.firstPlace.amount)*/
            println("총 수익률은 0%입니다.")

        }
    }
}

