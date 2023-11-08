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
            startGame()
        }
    }

    private fun lottoMoneyInput(): Int {
        val message = "구입금액을 입력해 주세요."
        return readIntFromConsole(message)
    }

    private fun readIntFromConsole(message: String): Int {
        while (true) {
            try {
                lottoView.printMessage(message)
                val input = Console.readLine().toInt()
                if (input % 1000 != 0) {
                    throw IllegalArgumentException("1000원 단위로 입력해 주세요.")
                }
                return input
            } catch (e: NumberFormatException) {
                lottoView.printMessage("[ERROR] 숫자를 입력해 주세요.")
            } catch (e: IllegalArgumentException) {
                lottoView.printMessage("[ERROR] ${e.message}")
            }
        }
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
        val message = "당첨 번호를 입력해 주세요."
        return readNumbersFromConsole(message, 6)
    }

    private fun lottoNumberBonus(): Int {
        val message = "\n보너스 번호를 입력해 주세요."
        return readNumbersFromConsole(message, 1)[0]
    }

    private fun readNumbersFromConsole(message: String, expectedSize: Int): List<Int> {
        while (true) {
            try {
                lottoView.printMessage(message)
                val input = Console.readLine()
                val numbers = input.split(",").map { it.trim().toInt() }
                if (numbers.size != expectedSize) {
                    throw IllegalArgumentException("입력한 숫자의 개수가 올바르지 않습니다.")
                }
                if (numbers.toSet().size != expectedSize) {
                    throw IllegalArgumentException("중복되는 번호가 있습니다.")
                }
                if (numbers.any { it < 1 || it > 45 }) {
                    throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다.")
                }
                return numbers
            } catch (e: NumberFormatException) {
                lottoView.printMessage("[ERROR] 숫자를 입력해 주세요.")
            } catch (e: IllegalArgumentException) {
                lottoView.printMessage("[ERROR] ${e.message}")
            }
        }
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
