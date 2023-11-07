package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    fun getInput(validator: InputValidateEnum): String {
        val input = Console.readLine()
        validator.validator(input)

        return input
    }
}