package com.gg.spora.user.data.local

import com.gg.spora.user.domain.IUserRepositoryLocal
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
    private val userDao: UserDao
) : IUserRepositoryLocal {
    override suspend fun setUserLocal(user: User) {
        userDao.insertUser(user.toUserEntity())
    }

    override suspend fun updateUserWithLevelCompleted(user: User, levelCompleted: LevelCompleted) {

        userDao.updateUser(user.toUserEntity())

        val levelsCompletedEntity = userDao.getLevelsCompletedByUserId(user.id).first()

        val levelCompletedFound = levelsCompletedEntity.find { it.levelId == levelCompleted.levelId }

        if(levelCompletedFound != null) {
            userDao.updateLevelCompleted(levelCompleted.toLevelCompletedEntity(user.id))
        } else{
            userDao.insertLevelCompleted(levelCompleted.toLevelCompletedEntity(user.id))
        }
    }

    override suspend fun updateUserIdByUserName(userId: String, userName: String) {
        userDao.updateUserIdByUserName(userId, userName)
    }

//    override suspend fun deleteUserById(id: String) {
//        userDao.deleteUserById(id)
//    }

    override fun getUserByIdFlow(userId: String): Flow<User> {
        return userDao.getUsersWithLevelsCompleted().map { users ->
            users.first { it.user.id == userId }.toUser()
        }
    }
}