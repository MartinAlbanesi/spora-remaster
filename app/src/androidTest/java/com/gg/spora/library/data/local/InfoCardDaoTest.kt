package com.gg.spora.library.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.library.domain.mappers.toInfoCardEntity
import com.gg.spora.library.domain.model.InfoCard
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class InfoCardDaoTest {

    private lateinit var infoCardDao: InfoCardDAO
    private lateinit var db: SporaDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SporaDatabase::class.java)
            .build()
        infoCardDao = db.infoCardDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertInfoCard_WhenInsertedOneValidInfoCard_ThenReturnInfoCardInserted() = runTest {

        //GIVEN
        val expectedInfoCard =
            InfoCardEntity("1", "test", "test", 1.toString(), true, category = StageType.FOREST)

        val actualInfoCardEmpty = infoCardDao.getInfoCardById("1")
        Assert.assertNull(actualInfoCardEmpty)

        //WHEN
        infoCardDao.insertInfoCard(expectedInfoCard)

        //THEN
        val actualInfoCard = infoCardDao.getInfoCardById("1")
        assertEquals(expectedInfoCard, actualInfoCard)
    }

    @Test
    fun getInfoCardListByCategory_WhenSearchByCategory_ThenReturnInfoCardListByCategory() =
        runTest {

            //GIVEN
            val expectedInfoCardList = listOf<InfoCard>(
                InfoCard("1", "test", "test", 1.toString(), true, category = StageType.FOREST),
                InfoCard("2", "test", "test", 1.toString(), true, category = StageType.FOREST),
                InfoCard("3", "test", "test", 1.toString(), true, category = StageType.FOREST),
            ).map {
                it.toInfoCardEntity()
            }
            val completeInfoCardList = listOf<InfoCard>(
                InfoCard("1", "test", "test", 1.toString(), true, category = StageType.FOREST),
                InfoCard("2", "test", "test", 1.toString(), true, category = StageType.FOREST),
                InfoCard("3", "test", "test", 1.toString(), true, category = StageType.FOREST),
                InfoCard("4", "test", "test", 1.toString(), true, category = StageType.LAKE),
                InfoCard("5", "test", "test", 1.toString(), true, category = StageType.LAKE),
                InfoCard("6", "test", "test", 1.toString(), true, category = StageType.DESERT),
                InfoCard("7", "test", "test", 1.toString(), true, category = StageType.DESERT),
                InfoCard("8", "test", "test", 1.toString(), true, category = StageType.DESERT),
                InfoCard("9", "test", "test", 1.toString(), true, category = StageType.DESERT),
            )

            //WHEN
            completeInfoCardList.forEach {
                infoCardDao.insertInfoCard(it.toInfoCardEntity())
            }

            //THEN
            val actualInfoCardList =
                infoCardDao.getInfoCardsByCategory(StageType.FOREST.name).first()

            assertEquals(expectedInfoCardList, actualInfoCardList)
        }


    @Test
    fun deleteInfoCard_SetAValidInfoCardToDelete_DeletedInfoCardFromDB() = runTest {

        // Given
        val expectedInfoCard =
            InfoCardEntity("1", "test", "test", 1.toString(), true, category = StageType.FOREST)

        infoCardDao.insertInfoCard(expectedInfoCard)

        // When
        infoCardDao.deleteInfoCard(expectedInfoCard)

        // Then
        val actualInfoCard = infoCardDao.getInfoCardById("1")
        Assert.assertNull(actualInfoCard)

    }

    @Test
    fun insertInfoCard_WhenUnlockInfoCard_ThenReturnUnlockedInfoCard() = runTest {


        //GIVEN
        val expectedInfoCard =
            InfoCardEntity("1", "test", "test", 1.toString(), true, category = StageType.FOREST)

        var actualInfoCard =
            InfoCardEntity("1", "test", "test", 1.toString(), false, category = StageType.FOREST)

        infoCardDao.insertInfoCard(actualInfoCard)

        //WHEN
        actualInfoCard = infoCardDao.getInfoCardById("1")!!
        actualInfoCard.isUnlocked = true
        infoCardDao.updateInfoCard(actualInfoCard)

        //THEN
        actualInfoCard = infoCardDao.getInfoCardById("1")!!
        assertEquals(expectedInfoCard.isUnlocked, actualInfoCard.isUnlocked)

    }
}