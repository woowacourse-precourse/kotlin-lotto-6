package lotto


fun promptLottoPrice(): Int {
    println(PromptMessages.WAITING_FOR_LOTTO_PRICE)
    while (true) {
        try {
            val digits = readLottoPrice()
            val price = parseLottoPrice(digits)
            validateLottoPrice(price)
            return price
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println(PromptMessages.TRY_AGAIN)
        }
    }
}

fun promptWinningNumber(): Pair<List<Int>, Int> {
    while (true) {
        try {
            println(PromptMessages.WAITING_FOR_NORMAL_WINNING_NUMBER)
            val normalNumberLine = readNormalWinningNumberLine()
            val normalNumbers = parseNormalWinningNumbers(normalNumberLine)
            println(PromptMessages.WAITING_FOR_BONUS_NUMBER)
            val bonusNumberLine = readBonusNumberLine()
            val bonusNumber = parseBonusNumber(bonusNumberLine)
            validateWinningNumber(normalNumbers to bonusNumber)
            return normalNumbers to bonusNumber
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println(PromptMessages.TRY_AGAIN)
        }
    }
}