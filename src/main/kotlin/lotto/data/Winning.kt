package lotto.data

import lotto.Constants

data class Winning(val numbers: List<Int>, val bonus: Int) {
    /**
     * 당첨 클래스
     *
     * 당첨 클래스는 당첨 번호와 보너스 번호로 구성된다.
     * 당첨 번호는 기존 로또의 형태와 동일하므로, 로또 객체 생성을 통해 유효성을 검사한다.
     */
    init {
        Lotto(numbers)
        require(bonus in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER) {
            Constants.ERROR_LOTTO_NUMBER_BOUNDARY_MESSAGE
        }
        require(!numbers.contains(bonus)) { Constants.ERROR_BONUS_NUMBER_DISTINCTION_MESSAGE }
    }
}
