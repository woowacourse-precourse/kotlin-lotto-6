package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    publishLotto()
}

// 로또 번호 생성을 캡슐화를 해야 하나 고민
fun publishLotto(): Lotto = Lotto(generateLottoNumbers())

fun generateLottoNumbers(): List<Int> =
    Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)