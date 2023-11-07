package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    val lottoGame = Lotto(lottoNumbers)
}
