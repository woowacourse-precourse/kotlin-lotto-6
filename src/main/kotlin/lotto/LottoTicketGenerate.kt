package lotto

import camp.nextstep.edu.missionutils.Randoms

fun pickLottoNumbers(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(
        LottoConstraints.NUMBER_START, LottoConstraints.NUMBER_END, LottoConstraints.NUMBER_COUNT
    )
}

fun makeLottoTicket(): Lotto {
    return Lotto(pickLottoNumbers())
}
