package lotto.domain

import camp.nextstep.edu.missionutils.Console

class IO {

    fun getInput() = Console.readLine()

    fun show(content: String, lineBreak: Boolean) {
        print(content)

        if (lineBreak) {
            println()
        }
    }
}