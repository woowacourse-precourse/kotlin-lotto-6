package lotto.Controller

import lotto.View.LottoView
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoController {
    private val lottoView = LottoView()
    enum class LottoPrize(val sameCount: Int, val prizeMoney: Int, val prizeName: String) {
        threeSame(3, 5000, "3개 일치"),
        fourSame(4, 50000, "4개 일치"),
        fiveSame(5, 1500000, "5개 일치"),
        fiveSamePlusBonus(5, 30000000, "5개 일치, 보너스 볼 일치"),
        sixSame(6, 2000000000, "6개 일치")
    }
    fun startGame() {
        try {
            val inputMoney = lottoMoneyInput()
            val count = lottoCnt(inputMoney)
            val lottoList = lottoNumberLimit(count)
            lottoView.printLottoNumbers(count, lottoList)

            val lottoNumber = lottoNumberChoose()
            val bonusNumber = lottoNumberBonus()

            val result = lottoNumberCheck(lottoList, lottoNumber, bonusNumber)
            lottoView.printResult(result, count)
        } catch (e: IllegalArgumentException) {
            lottoView.printMessage("[ERROR] ${e.message}")
        }
    }

    private fun lottoMoneyInput(): Int {
        lottoView.printMessage("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine().toInt()
        if (inputMoney % 1000 != 0) {
            throw IllegalArgumentException("1000원 단위로 입력해 주세요.")
        }
        return inputMoney
    }

    private fun lottoCnt(inputMoney: Int): Int {
        return inputMoney / 1000
    }

    private fun lottoNumberLimit(count: Int): List<List<Int>> {
        val comLottoList = mutableListOf<List<Int>>()
        repeat(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            comLottoList.add(numbers)
        }
        return comLottoList
    }

    private fun lottoNumberChoose(): List<Int> {
        lottoView.printMessage("당첨 번호를 입력해 주세요.")
        val lottoNumber = Console.readLine().split(",").map { it.toInt() }
        if (lottoNumber.toSet().size != 6) {
            throw IllegalArgumentException("중복되는 번호가 있습니다.")
        }
        if (lottoNumber.size != 6) {
            throw IllegalArgumentException("6개의 숫자를 입력하세요.")
        }
        return lottoNumber
    }

    private fun lottoNumberBonus(): Int {
        lottoView.printMessage("보너스 번호를 입력해 주세요.")
        return Console.readLine().toInt()
    }

    private fun lottoNumberCheck(lottoList: List<List<Int>>, comNumber: List<Int>, bonusNumber: Int): Map<String, Int> {
        val lottoMoneyList = mutableMapOf<String, Int>()
        lottoMoneyList["3개 일치"] = 0
        lottoMoneyList["4개 일치"] = 0
        lottoMoneyList["5개 일치"] = 0
        lottoMoneyList["5개 일치, 보너스 볼 일치"] = 0
        lottoMoneyList["6개 일치"] = 0

        for (lotto in lottoList) {
            val sameNumber = lotto.filter { it in comNumber }.size
            when (sameNumber) {
                3 -> lottoMoneyList["3개 일치"] = lottoMoneyList.getOrDefault("3개 일치", 0) + 1
                4 -> lottoMoneyList["4개 일치"] = lottoMoneyList.getOrDefault("4개 일치", 0) + 1
                5 -> {
                    if (lotto.contains(bonusNumber)) {
                        lottoMoneyList["5개 일치, 보너스 볼 일치"] =
                            lottoMoneyList.getOrDefault("5개 일치, 보너스 볼 일치", 0) + 1
                    } else {
                        lottoMoneyList["5개 일치"] = lottoMoneyList.getOrDefault("5개 일치", 0) + 1
                    }
                }
                6 -> lottoMoneyList["6개 일치"] = lottoMoneyList.getOrDefault("6개 일치", 0) + 1
            }
        }
        return lottoMoneyList
    }

}
