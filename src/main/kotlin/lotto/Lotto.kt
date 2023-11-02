package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    fun printnumbers()
    {
        val nums = numbers.joinToString(", ")
        println("[$nums]")
    }
}
