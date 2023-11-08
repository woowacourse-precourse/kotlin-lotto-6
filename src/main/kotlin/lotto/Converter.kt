package lotto

object Converter {
    fun convertStringToIntList(input: String): List<Int> = input.split(",").map { it.trim().toInt() }

    fun convertStringToInt(input: String) = input.toInt()
}
