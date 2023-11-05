package lotto

fun main() {
    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    val lottoView = LottoView() // LottoView 객체 생성
    val lottoController = LottoController(lottoView, lotto) // LottoController 객체 생성

    lottoController.run() // run 함수 호출
}

