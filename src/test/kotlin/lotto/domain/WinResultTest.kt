package lotto.domain

import lotto.domain.*
import lotto.service.WinResultService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WinResultTest {

    private lateinit var user : User
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun setWinningLotto(){
        winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
    }

    @Test
    fun `로또 번호와 당첨 번호가 6개 일치할 경우 1등이다`() {
        val user = User(1000, listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))
        val winResult = WinResultService().makeWinResult(user, winningLotto)
        assertThat(winResult.getPlaceResult().containsKey(Place.First))
    }

    @Test
    fun `로또 번호와 당첨 번호가 5개 일치하고 보너스 번호를 포함할 경우 2등이다`() {
        val user = User(1000,listOf(Lotto(listOf(1,2,3,4,5,7))))
        val winResult = WinResultService().makeWinResult(user,winningLotto)
        assertThat(winResult.getPlaceResult().containsKey(Place.Second))
    }

    @Test
    fun `로또 번호와 당첨 번호가 5개 일치하고 보너스 번호를 포함하지 않을 경우 3등이다`(){
        val user = User(1000, listOf(Lotto(listOf(1,2,3,4,5,10))))
        val winResult = WinResultService().makeWinResult(user,winningLotto)
        assertThat(winResult.getPlaceResult().containsKey(Place.Third))
    }

    @Test
    fun `로또 번호와 당첨번호가 4개 일치할 경우 4등이다`() {
        val user = User(1000, listOf(Lotto(listOf(1,2,3,4,10,11))))
        val winResult = WinResultService().makeWinResult(user,winningLotto)
        assertThat(winResult.getPlaceResult().containsKey(Place.Fourth))
    }

    @Test
    fun `로또 번호와 당첨번호가 3개 일치할 경우 5등이다`(){
        val user = User(1000, listOf(Lotto(listOf(1,2,3,11,12,13))))
        val winResult = WinResultService().makeWinResult(user,winningLotto)
        assertThat(winResult.getPlaceResult().containsKey(Place.Fifth))
    }
    @Test
    fun `기대 수익률 일치 확인`() {
        val user = User(1000, listOf(Lotto(listOf(1,2,3,11,12,13))))
        val expectedEarningRate = 500
        val winResult = WinResultService().makeWinResult(user,winningLotto)
        assertEquals(expectedEarningRate.toDouble(),winResult.getEarningRate())
    }
}