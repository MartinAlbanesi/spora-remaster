package com.gg.spora.user.data.local

import com.gg.spora.challenge.data.local.ChallengeDao
import com.gg.spora.challenge.domain.mappers.toObjectDetail
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.tutorials.data.local.entity.TutorialCompletedDao
import com.gg.spora.tutorials.domain.mapper.toTutorialCompleted
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.mappers.toLevelCompletedEntity
import com.gg.spora.user.domain.mappers.toUser
import com.gg.spora.user.domain.mappers.toUserEntity
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryLocal @Inject constructor(
    private val userDao: UserDao,
    private val tutorialCompletedDao: TutorialCompletedDao
) : IUserRepositoryLocal {

    override suspend fun setUserLocal(user: User) {
        userDao.insertUser(user.toUserEntity())
    }

    override suspend fun setLevelsCompleted(levelsCompleted: List<LevelCompletedEntity>) {
        userDao.insertLevelsCompleted(levelsCompleted)
    }

    override suspend fun updateUserWithLevelCompleted(user: User, levelCompleted: LevelCompleted) {

        userDao.updateUser(user.toUserEntity())

        val levelsCompletedEntity = userDao.getLevelsCompleted().first()

        val levelCompletedFound = levelsCompletedEntity.find { it.levelId == levelCompleted.levelId }

        if(levelCompletedFound != null) {
            userDao.updateLevelCompleted(levelCompleted.toLevelCompletedEntity(user.id))
        } else{
            userDao.insertLevelCompleted(levelCompleted.toLevelCompletedEntity(user.id))
        }
    }

    override suspend fun updateUserWithChallengeObjectCompleted(user: User, objectDetail: ObjectDetail) {
        userDao.updateUser(user.toUserEntity())
        userDao.setValidObjectDetailInDatabase(objectDetail.nameObjectDetail)
    }

    override suspend fun updateUserId(userId: String) {
        userDao.updateUserId(userId)
    }

//    override suspend fun deleteUserById(id: String) {
//        userDao.deleteUserById(id)
//    }

    override fun getUser(): Flow<User?> {
        return userDao.getUsersWithLevelsCompleted().map {
            it?.toUser(tutorialCompletedDao.getAllTutorialsCompleted().map { tutorialCompleted ->
                tutorialCompleted.toTutorialCompleted()
            })
        }
    }

    override suspend fun getAllObjectsDetailsValidate(): List<ObjectDetail> {
        return userDao.getAllObjectsDetailsValidate().map { it.toObjectDetail() }
    }

    override suspend fun getUserOxygen(): Flow<Int> {
        return userDao.getUserOxygen()
    }

    override suspend fun updateUserOxygen(oxygen: Int) {
        userDao.updateUserOxygen(oxygen)
    }

    override suspend fun updateLevelCompleted(levelCompleted: LevelCompletedEntity) {
        userDao.updateLevelCompleted(levelCompleted)
    }

    override suspend fun deleteUser() {
        userDao.deleteUser()
    }

    override suspend fun deleteLevelsCompleted() {
        userDao.deleteLevelsCompleted()
    }

//    override suspend fun getCurrentUserFlow(): List<User> {
//        return userDao.getUsersWithLevelsCompleted().first().map { it.toUser() }
//    }
}