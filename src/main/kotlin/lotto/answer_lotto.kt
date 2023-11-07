package lotto
import camp.nextstep.edu.missionutils.Console

class answer_lotto() {
    fun answer(): IntArray {
        val input = Console.readLine()
        val inputArray = input.split(",").map { it.trim().toIntOrNull() ?: 0 }.toIntArray()

        if (inputArray.size != 6) {
            inputArray.fill(0) // Handle invalid input by filling the array with 0
        }

        return inputArray
    }


    fun bonus():Int{
        val inputbonus = Console.readLine().toIntOrNull()
        if (inputbonus == null) {
            return 0 // Handle invalid input
        } else {
            return inputbonus
        }
    }


}