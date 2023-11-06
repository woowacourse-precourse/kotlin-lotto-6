package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        validate()
    }
    private fun validate(){
        require(numbers.size == 6)
        checkDuplicate(numbers)
        for(i in numbers.indices){
            checkNumber(numbers[i].toInt())
        }
    }
    private fun checkDuplicate(number: List<Int>) {
        if (number.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] 중복된 수가 있습니다.")
        }
    }
    private fun checkNumber(input: Int) {
        if(input < 1 || input > 45){
            throw IllegalArgumentException("[ERROR] 숫자가 1이나 45 사이에 있지 않습니다.")
        }
    }
    fun getNumbers(): List<Int> {
        return numbers
    }


}
