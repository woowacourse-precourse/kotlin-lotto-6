package lotto

fun main() {
    val lottoView = LottoView()
    val lottoController = LottoController(lottoView)

    lottoController.run()
}
