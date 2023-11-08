package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun purchaseAmount(): Int? = readLine().toIntOrNull()

    fun lottoNumbers(): List<Int?> =
        readLine().split(DELIMITER).map {
            it.trim().toIntOrNull()
        }.distinct()

    fun bonusLottoNumber() = readLine().toIntOrNull()

    companion object {
        const val DELIMITER = ","
    }
}