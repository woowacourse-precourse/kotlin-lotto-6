package lotto

import camp.nextstep.edu.missionutils.*

class NumberGenerator {

 public fun numberGenerate(): List<Int> {
     val numbers = mutableListOf<Int>() // 최초 생성할 번호들을 저장할 mutableList 생성
     while (numbers.size <= 6) {
         val randomNumber = Randoms.pickNumberInRange(1, 45)
         if (!numbers.contains(randomNumber))
             numbers.add(randomNumber)
     }

     val rtn_numbers: List<Int> = listOf( // return에 사용될 list 선언 후 초기화
         numbers[0], numbers[1], numbers[2],
         numbers[3], numbers[4], numbers[5])

     return rtn_numbers.sorted()
 }

}