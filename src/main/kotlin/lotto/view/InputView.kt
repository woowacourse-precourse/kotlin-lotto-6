package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun purchaseAmount(): Int? = readLine().toIntOrNull()

    fun lottoNumbers(): List<String> {
        val numbers = readLine()
        return numbers.split(DELIMITER).map { it.trim() }
    }

    fun bonusLottoNumber() = readLine().toIntOrNull()

    companion object {
        const val DELIMITER = ","
    }
}