package com.gg.spora.user.domain

import com.gg.spora.user.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserNetworkRepository {

    fun setUser(user: User) : String

    fun updateUserById(user: User, id: String)

    fun deleteUserById(id: String)

    fun getUserByEmailFlow(email: String): Flow<User>
}