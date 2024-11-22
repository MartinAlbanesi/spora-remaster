package com.gg.spora.library

import com.gg.spora.core.data.INetworkConnectivityChecker
import com.gg.spora.library.data.network.IInfoCardRepositoryNetwork
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.domain.usecases.GetAllInfoCardsUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Test

class GetAllInfoCardsUseCaseTest {

    private lateinit var getAllInfoCardsUseCase: GetAllInfoCardsUseCase

    @RelaxedMockK
    lateinit var infoCardLocalRepository: IInfoCardRepositoryLocal

    @RelaxedMockK
    lateinit var infoCardNetworkRepository: IInfoCardRepositoryNetwork

    @RelaxedMockK
    lateinit var networkChecker: INetworkConnectivityChecker

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getAllInfoCardsUseCase = GetAllInfoCardsUseCase(
            localRepository = infoCardLocalRepository,
            networkRepository = infoCardNetworkRepository,
            networkInfo = networkChecker
        )

    }

    @Test
    fun `invoke - When DB is empty - Then Return Nothing`() {

        //Given


        //When


        //Then

    }

    @Test
    fun `invoke - When DB contains infoCards - Then Return InfoCards`() {

        //Given


        //When


        //Then
    }

    @Test
    fun `invoke - When Network connection is unavailable - Then Return InfoCards from Local`() {

        //Given


        //When


        //Then
    }

}