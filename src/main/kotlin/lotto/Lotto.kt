package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        numbersVowel["${LottoSystem.round}"] = numbers
    }

    companion object {
        val numbersVowel = mutableMapOf<String, List<Int>>()
        fun allDisplay() {
            for (key in numbersVowel.keys) {
                println("로또번호 ${key} : ${numbersVowel[key]}")
            }
        }
    }
}
