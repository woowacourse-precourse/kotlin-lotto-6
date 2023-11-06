package lotto

class Lotto(private val numbers: List<Int>) {

    private val error = Error()
    init {
        require(numbers.size == 6)
        error.checkDuplicate(numbers)
        for(i in numbers.indices){
            error.checkNumber(numbers[i].toInt())
        }
    }
    fun getList(): List<Int> {
        return numbers
    }


}
