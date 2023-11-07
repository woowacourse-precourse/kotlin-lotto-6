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

    fun lottoMoneyInput(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine().toInt()
        if (inputMoney % 1000 != 0) {
            throw IllegalArgumentException("1000원 단위로 입력해 주세요.")
        }
        return inputMoney
    }

    fun lottoCnt(inputMoney: Int): Int {
        return inputMoney / 1000
    }

    fun lottoNumberLimit(count: Int): List<List<Int>> {
        val comLottoList = mutableListOf<List<Int>>()
        repeat(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            comLottoList.add(numbers)
        }
        return comLottoList
    }


    fun lottoNumberChoose(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val lottoNumber = Console.readLine().split(",").map { it.toInt() }
        if (lottoNumber.toSet().size != 6) {
            throw IllegalArgumentException("중복되는 번호가 있습니다.")
        }
        if (lottoNumber.size != 6) {
            throw IllegalArgumentException("6개의 숫자를 입력하세요.")
        }
        return lottoNumber
    }

    fun lottoNumberBonus(): Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun lottoNumberCheck(lottoList: List<List<Int>>, comNumber: List<Int>, bonusNumber: Int): Map<String, Int> {
        val lottoMoneyList = mutableMapOf(
            LottoPrize.threeSame.prizeName to 0,
            LottoPrize.fourSame.prizeName to 0,
            LottoPrize.fiveSame.prizeName to 0,
            LottoPrize.fiveSamePlusBonus.prizeName to 0,
            LottoPrize.sixSame.prizeName to 0
        )
        for (lotto in lottoList) {
            val sameNumber = lotto.filter { it in comNumber }.size
            when (sameNumber) {
                LottoPrize.threeSame.sameCount -> lottoMoneyList[LottoPrize.threeSame.prizeName] =
                    lottoMoneyList.getValue(LottoPrize.threeSame.prizeName) + 1

                LottoPrize.fourSame.sameCount -> lottoMoneyList[LottoPrize.fourSame.prizeName] =
                    lottoMoneyList.getValue(LottoPrize.fourSame.prizeName) + 1

                LottoPrize.fiveSame.sameCount -> {
                    if (lotto.contains(bonusNumber)) {
                        lottoMoneyList[LottoPrize.fiveSamePlusBonus.prizeName] =
                            lottoMoneyList.getValue(LottoPrize.fiveSamePlusBonus.prizeName) + 1
                    } else {
                        lottoMoneyList[LottoPrize.fiveSame.prizeName] =
                            lottoMoneyList.getValue(LottoPrize.fiveSame.prizeName) + 1
                    }
                }

                LottoPrize.sixSame.sameCount -> lottoMoneyList[LottoPrize.sixSame.prizeName] =
                    lottoMoneyList.getValue(LottoPrize.sixSame.prizeName) + 1
            }
        }
        return lottoMoneyList
    }

}