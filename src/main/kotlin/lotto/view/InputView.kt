package lotto.view

import camp.nextstep.edu.missionutils.Console
class InputView {

    fun readInput(): String = Console.readLine().trim()

    fun finish() = Console.close()

}