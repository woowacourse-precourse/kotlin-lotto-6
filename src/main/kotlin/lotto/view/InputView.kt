package lotto.view

import camp.nextstep.edu.missionutils.Console
class InputView {

    fun readUserInput(): String = Console.readLine().trim()

    fun finish() = Console.close()

}