package com.gg.spora.user.domain

import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.domain.mappers.toForestTree
import com.gg.spora.grove.domain.mappers.toSeedTree
import com.gg.spora.tutorials.domain.SetTutorialsLocalUseCase
import com.gg.spora.user.domain.mappers.toLevelCompletedEntity
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case to update the user's local data from the network
 * @param email: String
 */
class UpdateUserLocalDataFromNetworkUseCase @Inject constructor(
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val seedTreeRepositoryLocal: ISeedTreeRepositoryLocal,
    private val forestTreeRepositoryLocal: IForestTreeRepositoryLocal,
    private val setTutorialsLocalUseCase: SetTutorialsLocalUseCase
) {
    suspend operator fun invoke(
        email: String
    ) {
        val user = userRepositoryNetwork.getUserByEmailFlow(email).first()
        userRepositoryLocal.setUserLocal(user)
        val listForestTree = user.forestTrees.map { it.toForestTree() }
        for(forestTree in listForestTree){
            forestTreeRepositoryLocal.insertForestTree(forestTree)
        }
        val listSeedTrees = user.seedTrees.map { it.toSeedTree() }
        seedTreeRepositoryLocal.insertSeedTreesList(listSeedTrees)
        userRepositoryLocal.setLevelsCompleted(user.levelsCompleted.map { it.toLevelCompletedEntity(user.id) })

        setTutorialsLocalUseCase(user.tutorialsCompleted)
    }
}