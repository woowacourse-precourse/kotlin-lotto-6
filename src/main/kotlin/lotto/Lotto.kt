package lotto

import camp.nextstep.edu.missionutils.Randoms

//로또 번호를 생성하고, 입력된 로또 번호와 당첨 번호를 비교하여 당첨 정보를 반환하는 역할을 합니다.
class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    // TODO: 추가 기능 구현
}
