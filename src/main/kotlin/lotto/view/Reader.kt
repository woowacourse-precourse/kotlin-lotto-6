package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Message

object Reader {
    fun inputInt(): Int {
        val line = Console.readLine()
        val trimmed = line.trim()
        val errorMessage = Message.NotNumberError
        return trimmed.toIntOrNull() ?: throw IllegalArgumentException(errorMessage.toString())
    }

    fun inputIntList(delimiter: Char): List<Int> {
        val line = Console.readLine()
        val splitInput = line.split(delimiter)
        val errorMessage = Message.NotNumberError
        return splitInput.map {
            val trimmed = it.trim()
            trimmed.toIntOrNull() ?: throw IllegalArgumentException(errorMessage.toString())
        }
    }
}
