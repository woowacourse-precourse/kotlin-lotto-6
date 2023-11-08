package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun purchaseAmount(): Int = readLine().toIntOrNull() ?: 0

    fun lottoNumbers(): List<Int> =
        readLine().split(DELIMITER).map {
            it.trim().toInt()
        }.distinct()

    fun bonusLottoNumber() = readLine().toIntOrNull() ?: 0

    companion object {
        const val DELIMITER = ","
    }
}