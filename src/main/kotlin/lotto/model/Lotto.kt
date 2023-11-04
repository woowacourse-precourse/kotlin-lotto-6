package lotto

import camp.nextstep.edu.missionutils.Randoms

/*
    요구 사항 : 제공된 Lotto 클래스를 활용해 구현해야 한다.
    1. _numbers의 접근 제어자 private를 변경할 수 없다.
    2. Lotto에 필드를 추가할 수 없다.
    3. Lotto의 패키지 변경은 가능하다.
*/
class Lotto(private val _numbers: List<LottoNumber>) {
    val numbers: List<LottoNumber> get() = _numbers

    init {
        validateSize()
        validateDuplicate()
    }

    private fun validateSize() = require(_numbers.size == 6) { "Error Message" }

    private fun validateDuplicate() = require(_numbers.size == _numbers.toSet().size) { "Error Message" }
}

class LottoNumber(number: Int) {
//    init {
//        validate
//    }
}