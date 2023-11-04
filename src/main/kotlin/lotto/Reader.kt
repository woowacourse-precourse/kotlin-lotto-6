package lotto

import camp.nextstep.edu.missionutils.Console

object Reader {
    fun inputIntOrNull(): Int? {
        val line = Console.readLine()
        return line.toIntOrNull()
    }

    fun inputIntegerListOrNull(delimiter: Char): List<Int>? {
        val line = Console.readLine()
        val splittedInput = line.split(delimiter)
        return splittedInput.map {
            it.toIntOrNull() ?: return null
        }
    }
}
