package lotto

import lotto.store.Store
import lotto.store.clerk.KoreanLottoClerk
import lotto.store.machine.KoreanMachine

fun main() {
//    TODO("프로그램 구현")
    val lottoClerk = KoreanLottoClerk()
    val lottoMachine = KoreanMachine()
    val lottoStore = Store(lottoClerk, lottoMachine)

    lottoStore.startLotto()
}
