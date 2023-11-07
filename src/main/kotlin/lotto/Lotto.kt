package lotto

import camp.nextstep.edu.missionutils.Randoms

//로또 번호를 생성하고, 입력된 로또 번호와 당첨 번호를 비교하여 당첨 정보를 반환하는 역할을 합니다.
class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] 로또 번호는 6개여야 합니다."
        }

        require(numbers.toSet().size == 6) {
            "[ERROR] 로또 번호에 중복된 숫자가 있습니다."
        }

        require(numbers.all { it in 1..45 }) {
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        }
    }


    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

}
