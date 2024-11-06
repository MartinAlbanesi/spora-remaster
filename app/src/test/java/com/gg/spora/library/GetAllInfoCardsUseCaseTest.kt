package com.gg.spora.library

class GetAllInfoCardsUseCaseTest {
/*
    private lateinit var getAllInfoCardsUseCase: GetAllInfoCardsUseCase

    @RelaxedMockK
    lateinit var infoCardsRepositoryLocal: IInfoCardRepositoryLocal

    @RelaxedMockK
    lateinit var infoCardsRepositoryNetwork: IInfoCardRepositoryNetwork

    @RelaxedMockK
    lateinit var networkInfo: INetworkConnectivityChecker

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getAllInfoCardsUseCase =
            GetAllInfoCardsUseCase(
                infoCardsRepositoryLocal,
                infoCardsRepositoryNetwork,
                networkInfo
            )
    }

    @Test
    fun `invoke - When ListOf InfoCards Not Exist In Network or Local DB - Then Return Null`() = runTest {
        // Given
        coEvery { infoCardsRepositoryLocal.getAllInfoCards() } returns flowOf(emptyList())
        coEvery { infoCardsRepositoryNetwork.getAllInfoCards() } returns flowOf(emptyList())

        // When
        val result = getAllInfoCardsUseCase.invoke().first()

        // Then
        assertNull(result)

    }
*/
}