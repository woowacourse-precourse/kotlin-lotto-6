package lotto.Controller

import lotto.LottoGameModel

fun howManyBuyLotto(lottoPrice: String): Int {
    try {
        val price = lottoPrice.toInt()

        if (price % 1000 == 0) {
            return price / 1000
        } else {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 구입 금액을 숫자로 입력해 주세요.")
    }
}

object LottoController {
    private var lottoGameModel: LottoGameModel? = null

    fun gameStart() {
        println("구입금액을 입력해 주세요.")
        val lottoPrice = readLine()
        var lottoGameModel: LottoGameModel? = null

        if (lottoPrice != null) {
            try {
                val numberOfLottoTickets = howManyBuyLotto(lottoPrice)
                println("\n$numberOfLottoTickets 개를 구매했습니다.")
                lottoGameModel = LottoGameModel(numberOfLottoTickets)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }

        lottoGameModel?.run {
            printLottoNumbers()
        }
        println("\n당첨 번호를 입력해 주세요.")

        val winningNumbers = readLine()

        if (winningNumbers != null) {
            try {
                val parsedWinningNumbers = parseLottoNumbers(winningNumbers)
                lottoGameModel?.setWinningNumbers(parsedWinningNumbers)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }

        println("\n보너스 번호를 입력해 주세요.")

        val bonusNumber = readLine()

        if (bonusNumber != null) {
            try {
                val bonus = checkValidationBonusLottoNumbers(bonusNumber)
                lottoGameModel?.setBonusNumber(bonus)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }
}

fun parseLottoNumbers(input: String?): List<Int> {
    if (input == null) {
        throw IllegalArgumentException("[ERROR] 입력이 null입니다.")
    }

    val numbers = input.split(",").map { it.trim() }.filter { it.isNotEmpty() }

    if (numbers.size != 6) {
        throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.")
    }

    val lottoNumbers = numbers.map {
        try {
            val number = it.toInt()
            if (number < 1 || number > 45) {
                throw IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.")
            }
            number
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.")
        }
    }

    if (lottoNumbers.distinct().size != 6) {
        throw IllegalArgumentException("[ERROR] 중복되지 않은 6개의 숫자를 입력해야 합니다.")
    }

    return lottoNumbers
}

fun checkValidationBonusLottoNumbers(bonusNumber: String?): Int{
    if (bonusNumber == null) {
        throw IllegalArgumentException("[ERROR] 입력이 null입니다.")
    }

    try {
        val number = bonusNumber.toInt()
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.")
        }
        return number
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.")
    }
}
