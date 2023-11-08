package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {

    fun buy(num: Int): List<Lotto> {
        val lottos = makeLotto(num)
        printLottos(lottos)
        return lottos
    }

    private fun makeLotto(num: Int): List<Lotto> =
        (1..num).map {
            Lotto(Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT).sorted())
        }

    private fun printLottos(lottos: List<Lotto>) {
        println()
        println(String.format(RESULT_FORMAT, lottos.size))
        lottos.forEach {
            println(it)
        }
    }

    fun drawNumbers(): WinningNumbers {
        println()
        println(INPUT_WINNING_NUMBERS_MESSAGE)
        val winningNumbers = try {
            getWinningNumbers()
        } catch (iae: IllegalArgumentException) {
            printError(iae.message ?: "")
            getWinningNumbers()
        } catch (ise: IllegalStateException) {
            printError(SYSTEM_ERROR)
            getWinningNumbers()
        } catch (nse: NoSuchElementException) {
            printError(SYSTEM_ERROR)
            getWinningNumbers()
        }

        println()
        println(INPUT_BONUS_NUMBER_MESSAGE)
        val bonusNumber = try {
            getBonusNumber()
        } catch (iae: IllegalArgumentException) {
            printError(iae.message ?: "")
            getBonusNumber()
        } catch (ise: IllegalStateException) {
            printError(SYSTEM_ERROR)
            getBonusNumber()
        } catch (nse: NoSuchElementException) {
            printError(SYSTEM_ERROR)
            getBonusNumber()
        }

        return WinningNumbers(winningNumbers, bonusNumber)
    }

    private fun printError(message: String) = println("$PREFIX_ERROR $message")


    private fun getWinningNumbers(): List<Int> = try {
        val list = Console.readLine().split(",").map { it.trim().toInt() }
        val isOutOfRange = list.any { it !in MIN..MAX }
        if (isOutOfRange) {
            throw IllegalArgumentException(ERROR_OUT_OF_RANGE)
        }
        if (list.size != COUNT) {
            throw IllegalArgumentException(ERROR_LENGTH)
        }
        if (list.distinct().size != COUNT) {
            throw IllegalArgumentException(ERROR_DISTINCT)
        }
        list
    } catch (nfe: NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_INT)
    }


    private fun getBonusNumber(): Int = try {
        val input = Console.readLine().trim().toInt()
        if (input !in MIN..MAX) {
            throw IllegalArgumentException(ERROR_OUT_OF_RANGE)
        }
        input
    } catch (nfe: java.lang.NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_INT)
    }

    fun printResult(lottos: List<Lotto>, winningNumbers: WinningNumbers) {
        val calculateWinnings = calculateWinnings(lottos, winningNumbers)
        printStatistics(calculateWinnings)
        printReturnRate(lottos, calculateWinnings)
    }

    private fun calculateWinnings(lottos: List<Lotto>, winningNumbers: WinningNumbers): List<WinningState> {
        return lottos.map { it.compare(winningNumbers) }
    }

    private fun printStatistics(calculateWinnings: List<WinningState>) {
        println()
        println(STATISTICS_HEADER)
        val result = calculateWinnings.fold(IntArray(5)) { acc, item ->
            when (item) {
                WinningState.FIRST -> acc[0] += 1
                WinningState.SECOND -> acc[1] += 1
                WinningState.THIRD -> acc[2] += 1
                WinningState.FORTH -> acc[3] += 1
                WinningState.FIFTH -> acc[4] += 1
                else -> {}
            }
            acc
        }
        println("3개 일치 (5,000원) - ${result[4]}개")
        println("4개 일치 (50,000원) - ${result[3]}개")
        println("5개 일치 (1,500,000원) - ${result[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[1]}개")
        println("6개 일치 (2,000,000,000원) - ${result[0]}개")
    }

    private fun printReturnRate(lottos: List<Lotto>, calculateWinnings: List<WinningState>) {
        val rate = calculateWinnings.sumOf { it.price } / (lottos.size * 1000).toDouble() * 100
        println(String.format(RATE_FORMAT, rate))
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        private const val COUNT = 6
        private const val RESULT_FORMAT = "%d개를 구매했습니다."
        private const val STATISTICS_HEADER = "당첨 통계\n---"
        private const val RATE_FORMAT = "총 수익률은 %.1f%%입니다."
        private const val PREFIX_ERROR = "[ERROR]"
        private const val SYSTEM_ERROR = "시스템 오류입니다."
        private const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        private const val ERROR_OUT_OF_RANGE = "숫자는 $MIN ~ $MAX 까지 입력해주세요."
        private const val ERROR_LENGTH = "숫자 ${COUNT}개를 입력해주세요."
        private const val ERROR_DISTINCT = "중복된 숫자를 입력할 수 없습니다."
        private const val ERROR_NOT_INT = "숫자만 입력해주세요."
    }
}

enum class WinningState(val price: Int) {
    NONE(0),
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FORTH(50_000),
    FIFTH(5_000)
}