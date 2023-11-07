package lotto

fun main() {
    try {
        LottoProcess().start()
    } catch (_: IllegalArgumentException) {
    }
}


