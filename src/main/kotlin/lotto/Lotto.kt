package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){
            "[Error] 입력 값이 6개가 아니거나 당첨 번호에 문자열이 포함되어 있습니다."
        }
    }


    fun validateNumbers() {
        for (number in numbers) {
            if (number !in 1..45) {
                throw IllegalArgumentException("[Error] 1에서 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun validateRepeat(){
        val checkRepeat = mutableListOf<Int>()
        for(number in numbers){
            if(number in checkRepeat){
                throw IllegalArgumentException("[Error] 입력 값 중 중복된 숫자가 있습니다.")
            }
            checkRepeat.add(number)
        }
    }



}
