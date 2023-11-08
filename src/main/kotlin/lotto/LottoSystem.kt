package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class LottoSystem {
    // 작성순서 : 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체

    enum class Case {
    }

    companion object {
        const val buyPrice = "구입금액"
        const val chosenNumber = "당첨번호"
        const val bonusNumber = "보너스번호"
        const val lottoStatistics = "당첨통계"
        const val lottoGame = "로또게임"

        const val caseBuyPrice = 1
        const val caseChoseNumber = 2
        const val caseBonusNumber = 3
        fun informationMessage(messageCase: String) {
            println()
            println("[${messageCase}]")
            println("====================")
        }

        fun requestMessage(keyword: String) {
            when (keyword) {
                "구입금액" -> println("${keyword}을 숫자만 입력해주세요 (1000 단위, 최대 10만)")
                "당첨번호", "보너스번호" -> println("${keyword}를 입력해주세요")
            }
        }

        fun buyMessage(buyNumber: Int) {
            println("${buyNumber}개를 구매했습니다.")
        }

    }

}
