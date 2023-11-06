package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {

    fun getUserInput(): String? = Console.readLine()

    fun close() = Console.close()
}