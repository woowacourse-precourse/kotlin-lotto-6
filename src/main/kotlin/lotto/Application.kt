package lotto

import lotto.presentation.view.LottoView
import java.lang.IllegalArgumentException

fun main() {
    try {
        LottoView().play()
    } catch (e: IllegalArgumentException) {

    }
}
