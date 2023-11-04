package lotto

import camp.nextstep.edu.missionutils.Console

object Reader {
    fun inputIntOrNull(): Int? {
        val line = Console.readLine()
        return line.toIntOrNull()
    }
}
