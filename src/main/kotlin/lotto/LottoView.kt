package lotto

import camp.nextstep.edu.missionutils.Console

class LottoView {

    companion object {
        private const val ERROR = "[ERROR]"
        private const val BUY_PRICE = "구입금액을 입력해 주세요."
        private const val WINNING_NUM = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUM = "보너스 번호를 입력해 주세요."
        private const val WIN_STATICS = "당첨 통계"
    }

    fun priceInput(): Int {
        while (true) {
            try {
                println(BUY_PRICE)
                val input = Console.readLine()
                return validInput(input)
            } catch (e: NumberFormatException) {
                println("$ERROR 숫자를 입력해 주세요.")
            } catch (e: IllegalArgumentException) {
                println("$ERROR 유효한 구입금액을 입력해 주세요.")
            }
        }
    }

    fun printLottos(lottos: List<Lotto>) {
        println()
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lottoNumbers ->
            println(lottoNumbers)
        }
    }

    fun inputWinningNumbers(): List<Int> {
        while (true) {
            try {
                println()
                println(WINNING_NUM)
                val input = Console.readLine()
                val numbers = input.split(",").map { winNumbers ->
                    winNumbers.trim().toInt()
                }

                if (numbers.size != 6) {
                    throw NumberFormatException()
                }
                if (numbers.any { it !in 1..45 }) {
                    throw IllegalArgumentException()
                }
                return numbers
            } catch (e: NumberFormatException) {
                println("$ERROR 당첨 번호는 6개를 입력해 주세요.")
            } catch (e: IllegalArgumentException) {
                println("$ERROR 당첨 번호는 1~45사이로 입력해 주세요.")
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            try {
                println()
                println(BONUS_NUM)
                val bonus = Console.readLine().toInt()
                if (bonus !in 1..45) {
                    throw IllegalArgumentException()
                }
                return bonus
            } catch (e: NumberFormatException) {
                println("$ERROR 보너스 번호는 숫자 한 개만 정확히 입력해 주세요.")
            } catch (e: IllegalArgumentException) {
                println("$ERROR 보너스 번호는 1~45사이로 입력해 주세요.")
            }
        }
    }

    fun showResult(result: Map<Rank, Int>, price: Int) {
        println()
        println(WIN_STATICS)
        println("---")

        Rank.entries.filter { it != Rank.NONE }.forEach { rank ->
            when (rank) {
                Rank.SECOND -> println(
                    "${rank.matchCount}개 일치, 보너스 볼 일치 (${formating(rank.prize)}원) - ${
                        result.getOrDefault(
                            rank,
                            0
                        )
                    }개"
                )

                else -> println("${rank.matchCount}개 일치 (${formating(rank.prize)}원) - ${result.getOrDefault(rank, 0)}개")
            }
        }
        val totalPrize = result.entries.sumOf { (rank, count) -> rank.prize * count }
        val profitRate = (totalPrize.toDouble() / price) * 100

        println("총 수익률은 ${String.format("%,.1f", profitRate)}%입니다.")
    }

    private fun validInput(input: String?): Int {
        val amount = input?.toIntOrNull() ?: throw IllegalArgumentException()

        if (amount % 1000 != 0 || amount == 0)
            throw IllegalArgumentException()

        return amount
    }

    private fun formating(number: Int): String {
        return String.format("%,d", number)
    }
}