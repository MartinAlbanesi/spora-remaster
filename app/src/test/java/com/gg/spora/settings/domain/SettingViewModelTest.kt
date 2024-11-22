package com.gg.spora.settings.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gg.spora.login.domain.LogOutUseCase
import com.gg.spora.settings.ui.SettingViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class SettingViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val logOutUseCase: LogOutUseCase = mock(LogOutUseCase::class.java)
    private val viewModel = SettingViewModel(logOutUseCase)

    @Test
    fun givenSettingViewModel_whenLogout_thenLogOutUseCaseIsCalled() = runBlockingTest {

        val onNavigateToLogin = mock(Runnable::class.java)

        viewModel.logout { onNavigateToLogin.run() }

        verify(logOutUseCase).invoke()
        verify(onNavigateToLogin).run()
    }
}